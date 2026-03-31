import java.util.*;
import java.util.regex.*;

public class DocumentRedactionEngine {

    static String processLine(String input) {
        // Rule 1: Mask National ID - ID:<3 uppercase letters><6 digits> → ID:XXX******
        input = input.replaceAll("ID:[A-Z]{3}(\\d{6})", "ID:XXX******");

        // Rule 2: Mask Bank Account - ACCT-XXXX-XXXX-XXXX → ACCT---XXXX (last 4 visible)
        input = input.replaceAll("ACCT-\\d{4}-\\d{4}-(\\d{4})", "ACCT---$1");

        // Rule 3: Normalize repeated words (case insensitive)
        Pattern repeatWord = Pattern.compile("\\b(\\w+)(\\s+\\1)+\\b", Pattern.CASE_INSENSITIVE);
        Matcher m = repeatWord.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, Matcher.quoteReplacement(m.group(1)));
        }
        m.appendTail(sb);
        input = sb.toString();

        // Rule 4: Remove trailing repeated special symbols (3 or more) → keep just one
        input = input.replaceAll("([!?.]){3,}$", "$1");

        return input;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            System.out.println(processLine(line));
        }
        sc.close();
    }
}
