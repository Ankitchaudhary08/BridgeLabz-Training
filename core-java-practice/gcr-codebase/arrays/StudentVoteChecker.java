import java.util.*;

public class StudentVoteChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define an array of 10 integer elements
        int[] studentAges = new int[10];

        System.out.println("Enter the ages of 10 students:");

        // Take user input for the student's age
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            studentAges[i] = sc.nextInt();
        }

        System.out.println("\nVoting Eligibility Results:");

        // Loop through the array using the length property
        for (int i = 0; i < studentAges.length; i++) {
            if (studentAges[i] < 0) {
                System.out.println("Invalid age");
            } else if (studentAges[i] >= 18) {
                System.out.println("The student with the age " + studentAges[i] + " can vote.");
            } else {
                System.out.println("The student with the age " + studentAges[i] + " cannot vote.");
            }
        }
       
    }
}
