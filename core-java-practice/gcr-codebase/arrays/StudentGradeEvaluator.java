import java.util.Scanner;

public class StudentGradeEvaluator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total number of students: ");
        int studentCount = scanner.nextInt();

        // Arrays to store data
        int[][] subjectMarks = new int[studentCount][3]; // 0-Physics, 1-Chemistry, 2-Maths
        double[] percentage = new double[studentCount];
        char[] grade = new char[studentCount];

        // Input marks with validation
        for (int i = 0; i < studentCount; i++) {
            System.out.println("\nStudent " + (i + 1));

            for (int subject = 0; subject < 3; subject++) {
                String subjectName;

                if (subject == 0) subjectName = "Physics";
                else if (subject == 1) subjectName = "Chemistry";
                else subjectName = "Maths";

                System.out.print("Enter marks for " + subjectName + ": ");
                int marks = scanner.nextInt();

                // Validate marks
                if (marks < 0) {
                    System.out.println("Marks cannot be negative. Please re-enter.");
                    subject--; // retry same subject
                    continue;
                }

                subjectMarks[i][subject] = marks;
            }
        }

        // Calculate percentage and grade
        for (int i = 0; i < studentCount; i++) {
            int totalMarks = 0;

            for (int j = 0; j < 3; j++) {
                totalMarks += subjectMarks[i][j];
            }

            percentage[i] = totalMarks / 3.0;

            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }

        // Display final result
        System.out.println("\n===== STUDENT RESULT REPORT =====");

        for (int i = 0; i < studentCount; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Physics   : " + subjectMarks[i][0]);
            System.out.println("Chemistry : " + subjectMarks[i][1]);
            System.out.println("Maths     : " + subjectMarks[i][2]);
            System.out.println("Percentage: " + percentage[i] + "%");
            System.out.println("Grade     : " + grade[i]);
            System.out.println("---------------------------------");
        }

        
    }
}
