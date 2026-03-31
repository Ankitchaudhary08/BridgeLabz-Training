import java.util.*;
import java.util.regex.*;

public class URLValidationSystem {

    static Set<String> seen = new LinkedHashSet<>();

    static String validateURL(String url) {
        // 1. Format check: must match <http:// or https://><websiteName><domain>
        if (!url.matches("(https?|[a-z]+)://[^/]+")) {
            // Check if structure is completely off
            if (!url.contains("://")) return "INVALID URL: format is invalid";
        }

        // 2. Protocol check
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            if (url.matches("[a-z]+://.*")) return "INVALID URL: protocol is invalid";
            return "INVALID URL: format is invalid";
        }

        // Strip protocol
        String withoutProtocol = url.substring(url.indexOf("://") + 3);

        // 3. Website name + domain extraction
        // Expected: <websiteName><domain> where domain is .com/.co/.in/.org/.gov
        Pattern urlPattern = Pattern.compile("^([a-zA-Z0-9_-]+)(\\.[a-z]+)$");
        Matcher m = urlPattern.matcher(withoutProtocol);

        if (!m.matches()) {
            return "INVALID URL: format is invalid";
        }

        String websiteName = m.group(1);
        String domain = m.group(2);

        // 3. Website name validation: only lowercase, max 10 chars
        if (!websiteName.matches("[a-z]{1,10}")) {
            return "INVALID URL: website name is invalid";
        }

        // 4. Domain validation
        Set<String> validDomains = new HashSet<>(Arrays.asList(".com", ".co", ".in", ".org", ".gov"));
        if (!validDomains.contains(domain)) {
            return "INVALID URL: domain is invalid";
        }

        // 5. Duplicate check
        if (seen.contains(url)) {
            return "DUPLICATE URL FOUND";
        }

        seen.add(url);
        return "VALID URL";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String url = sc.nextLine().trim();
            System.out.println(validateURL(url));
        }
        sc.close();
    }
}
