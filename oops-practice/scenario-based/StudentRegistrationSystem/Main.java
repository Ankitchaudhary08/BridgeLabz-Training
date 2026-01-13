package StudentRegistrationSystem;
public class Main {
    public static void main(String[] args) {

        Student student = new Student("Ankit", 21, "CS101");
        RegistrationService service = new RegistrationServiceImpl();

        try {
            service.enrollCourse(student, "Java");
            service.enrollCourse(student, "DSA");
            service.enrollCourse(student, "DBMS");
            service.enrollCourse(student, "OS"); // Exception here
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }

        student.addGrade("Java", "A");
        student.addGrade("DSA", "A+");

        student.viewGrades();
    }
}
