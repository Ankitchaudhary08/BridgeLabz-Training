import java.util.Scanner;

public class StudentScores {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n;

        // Validate number of students
        try {
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Invalid number of students.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
            return;
        }

        int[] scores = new int[n];
        int sum = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        // Input scores with validation
        for (int i = 0; i < n; i++) {
            System.out.print("Enter score of student " + (i + 1) + ": ");

            try {
                int score = sc.nextInt();

                if (score < 0) {
                    System.out.println("Score cannot be negative.");
                    i--; // retry same index
                    continue;
                }

                scores[i] = score;
                sum += score;

                if (score > highest) highest = score;
                if (score < lowest) lowest = score;

            } catch (Exception e) {
                System.out.println("Invalid input. Enter numeric value.");
                sc.next(); // clear invalid input
                i--; // retry
            }
        }

        double average = (double) sum / n;

        // Output
        System.out.println("\nAverage Score: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        System.out.println("Scores above average:");
        for (int score : scores) {
            if (score > average) {
                System.out.println(score);
            }
        }

        sc.close();
    }
}
