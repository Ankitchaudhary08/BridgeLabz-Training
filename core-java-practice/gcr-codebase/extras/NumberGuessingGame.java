import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    static int generateGuess(int low, int high) {
        Random rd = new Random();
        // generate guess between low and high
        return rd.nextInt(high - low + 1) + low;
    }

    static String getFeedback(Scanner sc) {
        // user tell feedback: high, low or correct
        System.out.print("Enter feedback (high/low/correct): ");
        return sc.nextLine();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int low = 1, high = 100;
        boolean guessed = false;

        System.out.println("Think a number between 1 to 100");

        while (!guessed) {
            int guess = generateGuess(low, high);
            System.out.println("Computer guess: " + guess);

            String feedback = getFeedback(sc);

            if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            } else if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            } else if (feedback.equalsIgnoreCase("correct")) {
                guessed = true;
                System.out.println("Computer guessed correct!");
            }
        }
        sc.close();
    }
}
