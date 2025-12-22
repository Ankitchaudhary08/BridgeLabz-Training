
import java.util.*;

public class StringToCharArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = scanner.next();
        

        // Get char array using user-defined method
        char[] customCharArray = stringToChars(text);

        // Get char array using built-in method
        char[] builtInCharArray = text.toCharArray();

        // Compare the two arrays using a custom method
        boolean areEqual = compareCharArrays(customCharArray, builtInCharArray);

        // Display the results
        System.out.println("Custom toCharArray() result: " + Arrays.toString(customCharArray));
        System.out.println("Built-in toCharArray() result: " + Arrays.toString(builtInCharArray));

        if (areEqual) {
            System.out.println("The results from both methods are identical.");
        } else {
            System.out.println("The results from the methods do not match.");
        }
    }

  
    public static char[] stringToChars(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }


    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}