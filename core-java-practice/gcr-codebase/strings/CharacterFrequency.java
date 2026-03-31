import java.util.Scanner;

public class CharacterFrequency {

    // Method to find frequency of characters using charAt()
    public static String[][] findCharFrequency(String text) {
        int[] freq = new int[256]; // ASCII size

        // Count frequency
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] > 0) {
                uniqueCount++;
                freq[text.charAt(i)] = -freq[text.charAt(i)]; // mark counted
            }
        }

        // Create result array
        String[][] result = new String[uniqueCount][2];
        int index = 0;

        // Store characters and frequency
        for (int i = 0; i < 256; i++) {
            if (freq[i] < 0) {
                result[index][0] = String.valueOf((char) i);
                result[index][1] = String.valueOf(-freq[i]);
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] frequency = findCharFrequency(text);

        System.out.println("\nCharacter\tFrequency");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println(frequency[i][0] + "\t\t" + frequency[i][1]);
        }

        sc.close();
    }
}
