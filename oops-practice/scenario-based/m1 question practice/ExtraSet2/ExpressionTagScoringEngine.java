import java.util.*;
import java.util.regex.*;

public class ExpressionTagScoringEngine {

    static String evaluate(String input) {
        // Match all [OPERATION:EXPRESSION] patterns including broken ones
        StringBuffer sb = new StringBuffer();
        Pattern findTags = Pattern.compile("\\[([^\\[\\]]*)\\]|(\\[[^\\]]*$)");
        Matcher m = findTags.matcher(input);

        while (m.find()) {
            String fullMatch = m.group(0);
            if (!fullMatch.endsWith("]")) {
                // Broken tag
                m.appendReplacement(sb, "ERROR");
                continue;
            }

            String inner = m.group(1);
            if (inner == null) {
                m.appendReplacement(sb, "ERROR");
                continue;
            }

            // Parse OPERATION:EXPRESSION
            int colonIdx = inner.indexOf(':');
            if (colonIdx < 0) {
                m.appendReplacement(sb, "ERROR");
                continue;
            }

            String op = inner.substring(0, colonIdx);
            String expr = inner.substring(colonIdx + 1);

            if (!op.equals("SUM") && !op.equals("MUL") && !op.equals("MAX") && !op.equals("MIN")) {
                m.appendReplacement(sb, "ERROR");
                continue;
            }

            if (expr.contains(" ")) {
                m.appendReplacement(sb, "ERROR");
                continue;
            }

            String[] nums = expr.split(",", -1);
            if (nums.length < 2) {
                m.appendReplacement(sb, "ERROR");
                continue;
            }

            boolean valid = true;
            List<Integer> values = new ArrayList<>();
            for (String num : nums) {
                if (!num.matches("-?(0|[1-9]\\d*)")) {
                    valid = false;
                    break;
                }
                try {
                    values.add(Integer.parseInt(num));
                } catch (NumberFormatException e) {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                m.appendReplacement(sb, "ERROR");
                continue;
            }

            long result = 0;
            switch (op) {
                case "SUM":
                    result = values.stream().mapToLong(Integer::longValue).sum();
                    break;
                case "MUL":
                    result = 1;
                    for (int v : values) result *= v;
                    break;
                case "MAX":
                    result = values.stream().mapToLong(Integer::longValue).max().getAsLong();
                    break;
                case "MIN":
                    result = values.stream().mapToLong(Integer::longValue).min().getAsLong();
                    break;
            }
            m.appendReplacement(sb, String.valueOf(result));
        }
        m.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            System.out.println(evaluate(line));
        }
        sc.close();
    }
}
