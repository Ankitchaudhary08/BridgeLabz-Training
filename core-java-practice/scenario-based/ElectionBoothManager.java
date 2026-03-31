import java.util.Scanner;

public class ElectionBoothManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Variables to store vote count of each candidate
        int candidate1Votes = 0;
        int candidate2Votes = 0;
        int candidate3Votes = 0;

        // Loop for multiple voters
        while (true) {

            // Taking age input from user
            System.out.print("Enter your age (enter -1 to exit): ");
            int age = sc.nextInt();

            // Special code to exit the voting process
            if (age == -1) {
                System.out.println("Voting process stopped.");
                break;
            }

            // Check if voter is eligible or not
            if (age >= 18) {

                // Asking voter to choose candidate
                System.out.println("You are eligible to vote.");
                System.out.println("Press 1 for Candidate 1");
                System.out.println("Press 2 for Candidate 2");
                System.out.println("Press 3 for Candidate 3");

                System.out.print("Enter your vote: ");
                int vote = sc.nextInt();

                // Recording vote using if-else
                if (vote == 1) {
                    candidate1Votes++;
                    System.out.println("Vote given to Candidate 1");
                } else if (vote == 2) {
                    candidate2Votes++;
                    System.out.println("Vote given to Candidate 2");
                } else if (vote == 3) {
                    candidate3Votes++;
                    System.out.println("Vote given to Candidate 3");
                } else {
                    // If voter enter wrong choice
                    System.out.println("Invalid vote. Vote not counted.");
                }

            } else {
                // If age is less than 18
                System.out.println("You are not eligible for vote.");
            }

            System.out.println("--------------------------------");
        }

        // Displaying final voting result
        System.out.println("\nFinal Voting Results:");
        System.out.println("Candidate 1 Votes: " + candidate1Votes);
        System.out.println("Candidate 2 Votes: " + candidate2Votes);
        System.out.println("Candidate 3 Votes: " + candidate3Votes);

    }
}
