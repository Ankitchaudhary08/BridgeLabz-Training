import java.util.ArrayList;
import java.util.List;

// Custom Exception
class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

// Student class (Model)
class Student {
    private String name;
    private String[] subjects;
    private int[] marks;

    public Student(String name, String[] subjects, int[] marks)
            throws InvalidMarkException {

        if (subjects.length != marks.length) {
            throw new InvalidMarkException("Subjects and marks count mismatch.");
        }

        // Validate marks
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException(
                        "Marks should be between 0 and 100."
                );
            }
        }

        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public int[] getMarks() {
        return marks;
    }
}

// Report Generator class
class ReportGenerator {

    // Calculate average marks
    public double calculateAverage(int[] marks) {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return sum / (double) marks.length;
    }

    // Assign grade
    public String assignGrade(double average) {
        if (average >= 80) {
            return "A";
        } else if (average >= 60) {
            return "B";
        } else if (average >= 40) {
            return "C";
        } else {
            return "Fail";
        }
    }

    // Display report card
    public void displayReport(Student student) {

        System.out.println("\n------------------------------");
        System.out.println("Report Card");
        System.out.println("Student Name: " + student.getName());
        System.out.println("------------------------------");

        String[] subjects = student.getSubjects();
        int[] marks = student.getMarks();

        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-10s : %3d\n", subjects[i], marks[i]);
        }

        double avg = calculateAverage(marks);
        String grade = assignGrade(avg);

        System.out.println("------------------------------");
        System.out.printf("Average     : %.2f\n", avg);
        System.out.println("Grade       : " + grade);
        System.out.println("------------------------------");
    }
}

// Application class
public class StudentReportApp {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        ReportGenerator generator = new ReportGenerator();

        String[] subjects = {"Math", "Physics", "Chemistry"};

        try {
            Student s1 = new Student(
                    "Ankit",
                    subjects,
                    new int[]{85, 78, 90}
            );

            Student s2 = new Student(
                    "Rahul",
                    subjects,
                    new int[]{65, 55, 60}
            );

            students.add(s1);
            students.add(s2);

            for (Student s : students) {
                generator.displayReport(s);
            }

        } catch (InvalidMarkException e) {
            System.out.println(e.getMessage());
        }
    }
}
