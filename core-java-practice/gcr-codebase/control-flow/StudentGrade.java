import java.util.Scanner;
public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input marks
        System.out.print("Enter Physics marks: ");
        double physics = sc.nextDouble();

        System.out.print("Enter Chemistry marks: ");
        double chemistry = sc.nextDouble();

        System.out.print("Enter Maths marks: ");
        double maths = sc.nextDouble();

        // Calculate total and percentage
        double total = physics + chemistry + maths;
        double percentage = total / 3;

        char grade;
        String remarks;

        // Grade calculation
        if (percentage >= 80) {
            grade = 'A';
            remarks = "Level 4, above agency-normalized standards";
        } else if (percentage >= 70) {
            grade = 'B';
            remarks = "Level 3, at agency-normalized standards";
        } else if (percentage >= 60) {
            grade = 'C';
            remarks = "Level 2, approaching agency-normalized standards";
        } else if (percentage >= 50) {
            grade = 'D';
            remarks = "Level 1, well below agency-normalized standards";
        } else if (percentage >= 40) {
            grade = 'E';
            remarks = "Too below agency-normalized standards";
        } else {
            grade = 'R';
            remarks = "Remedial standards";
        }

        // Output
        System.out.println("\nAverage Mark: " + percentage);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
    }
}
