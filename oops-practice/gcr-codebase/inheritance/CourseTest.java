// Base class
class Course {
    String courseName;
    int duration; // in hours

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

// Subclass 1
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass 2
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform,
                     boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Course Fee: " + fee);
        System.out.println("Discount: " + discount + "%");
        double finalFee = fee - (fee * discount / 100);
        System.out.println("Final Fee: " + finalFee);
    }
}

// Main class
public class CourseTest {
    public static void main(String[] args) {

        PaidOnlineCourse course = new PaidOnlineCourse(
                "Java Programming",
                40,
                "Udemy",
                true,
                5000,
                20
        );

        course.displayInfo();
    }
}
