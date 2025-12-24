import java.util.Scanner;

public class HandshakeProgram {

    // this method calculate max handshakes using formula
    public static int calculateHandshakes(int numberOfStudents) {

        // applying combination formula n*(n-1)/2
        int totalHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        return totalHandshakes;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking number of students from user
        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();

        // calling method to find handshakes
        int result = calculateHandshakes(numberOfStudents);

        // showing final output
        System.out.println(
                "The number of possible handshakes is " + result
        );

        sc.close();
    }
}
