import java.util.Scanner;

public class HandshakeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take number of students as input
        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();

        // Formula to calculate maximum handshakes
        // Combination = n * (n - 1) / 2
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        // Print result
        System.out.println(
            "The maximum number of handshakes among " +
            numberOfStudents + " students is " + handshakes
        );
    }
}
