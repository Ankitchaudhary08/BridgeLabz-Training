import java.util.Scanner;

public class StudentResult2D {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int totalStudents = sc.nextInt();

        // 2D array to store marks [student][subject]
        // 0 → Physics, 1 → Chemistry, 2 → Maths
        int[][] marks = new int[totalStudents][3];

        double[] percentages = new double[totalStudents];
        char[] grades = new char[totalStudents];

        // Taking marks input with validation
        for (int i = 0; i < totalStudents; i++) {
            System.out.println("\nStudent " + (i + 1));

            for (int j = 0; j < 3; j++) {
                String subject;

                if (j == 0) subject = "Physics";
                else if (j == 1) subject = "Chemistry";
                else subject = "Maths";

                System.out.print("Enter " + subject + " marks: ");
                int value = sc.nextInt();

                if (value < 0) {
                    System.out.println("Invalid marks! Enter positive value.");
                    j--; // retry same subject
                    continue;
                }

                marks[i][j] = value;
            }
        }

        // Calculate percentage and grade using 2D array
        for (int i = 0; i < totalStudents; i++) {
            int sum = 0;

            for (int j = 0; j < 3; j++) {
                sum += marks[i][j];
            }

            percentages[i] = sum / 3.0;

            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        // Display result
        System.out.println("\n------ STUDENT REPORT ------");
        for (int i = 0; i < totalStudents; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Physics   : " + marks[i][0]);
            System.out.println("Chemistry : " + marks[i][1]);
            System.out.println("Maths     : " + marks[i][2]);
            System.out.println("Percentage: " + percentages[i] + "%");
            System.out.println("Grade     : " + grades[i]);
            System.out.println("----------------------------");
        }

        sc.close();
    }
}
