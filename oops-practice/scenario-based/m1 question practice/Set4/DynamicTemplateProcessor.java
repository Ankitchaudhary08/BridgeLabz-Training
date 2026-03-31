import java.util.*;
import java.util.regex.*;

public class DynamicTemplateProcessor {

    static String processTemplate(String line) {
        // Find all placeholders ${TYPE:VALUE}
        Pattern p = Pattern.compile("\\$\\{([^}]+)\\}");
        Matcher m = p.matcher(line);
        StringBuffer sb = new StringBuffer();

        while (m.find()) {
            String inner = m.group(1);
            String[] parts = inner.split(":", 2);
            if (parts.length < 2) {
                m.appendReplacement(sb, "INVALID");
                continue;
            }
            String type = parts[0];
            String value = parts[1];
            String replacement;

            switch (type) {
                case "DATE":
                    // DD-MM-YYYY → YYYY/MM/DD
                    if (value.matches("\\d{2}-\\d{2}-\\d{4}")) {
                        String[] dateParts = value.split("-");
                        int day = Integer.parseInt(dateParts[0]);
                        int month = Integer.parseInt(dateParts[1]);
                        int year = Integer.parseInt(dateParts[2]);
                        // Validate
                        if (day >= 1 && day <= 31 && month >= 1 && month <= 12) {
                            replacement = year + "/" + dateParts[1] + "/" + dateParts[0];
                        } else {
                            replacement = "INVALID";
                        }
                    } else {
                        replacement = "INVALID";
                    }
                    break;
                case "UPPER":
                    replacement = value.toUpperCase();
                    break;
                case "LOWER":
                    replacement = value.toLowerCase();
                    break;
                case "REPEAT":
                    String[] repeatParts = value.split(",");
                    if (repeatParts.length == 2) {
                        try {
                            String word = repeatParts[0];
                            int count = Integer.parseInt(repeatParts[1]);
                            StringBuilder rep = new StringBuilder();
                            for (int i = 0; i < count; i++) rep.append(word);
                            replacement = rep.toString();
                        } catch (NumberFormatException e) {
                            replacement = "INVALID";
                        }
                    } else {
                        replacement = "INVALID";
                    }
                    break;
                default:
                    replacement = "INVALID";
            }
            m.appendReplacement(sb, Matcher.quoteReplacement(replacement));
        }
        m.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            System.out.println(processTemplate(line));
        }
        sc.close();
    }
}
