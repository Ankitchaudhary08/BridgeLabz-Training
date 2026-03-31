class Course {
    // Instance variables (unique for each course)
    String courseName;
    int duration;     // in months
    double fee;

    // Class variable (shared by all courses)
    static String instituteName = "GLA University";

    // Constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: ₹" + fee);
        System.out.println("Institute: " + instituteName);
    }

    // Class (static) method
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}

public class CourseTest {
    public static void main(String[] args) {

        Course c1 = new Course("Java Programming", 6, 12000);
        Course c2 = new Course("Cloud Computing", 4, 18000);

        c1.displayCourseDetails();
        System.out.println();

        c2.displayCourseDetails();
        System.out.println();

        // Update institute name for all courses
        Course.updateInstituteName("GLA Tech Institute");

        System.out.println("After Institute Name Update:\n");
        c1.displayCourseDetails();
    }
}
