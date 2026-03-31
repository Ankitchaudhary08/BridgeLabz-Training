import java.util.Scanner;

public class CharFrequencyUsingUnique {

    // Method to find unique characters using charAt()
    public static char[] uniqueCharacters(String text) {
        int n = getLength(text);
        char[] temp = new char[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[count++] = current;
            }
        }

        char[] unique = new char[count];
        for (int i = 0; i < count; i++) {
            unique[i] = temp[i];
        }
        return unique;
    }

    // Method to find string length without using length()
    public static int getLength(String text) {
        int len = 0;
        try {
            while (true) {
                text.charAt(len);
                len++;
            }
        } catch (Exception e) {
            return len;
        }
    }

    // Method to find frequency using unique characters
    public static String[][] findFrequency(String text) {
        int[] freq = new int[256];
        int n = getLength(text);

        for (int i = 0; i < n; i++) {
            freq[text.charAt(i)]++;
        }

        char[] unique = uniqueCharacters(text);
        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[unique[i]]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] output = findFrequency(text);

        System.out.println("Character\tFrequency");
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + "\t\t" + output[i][1]);
        }
    }
}
