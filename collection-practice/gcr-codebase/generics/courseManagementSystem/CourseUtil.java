import java.util.List;

// Utility class for handling multiple course types
public class CourseUtil {

    // Wildcard method to handle any type of course
    public static void displayAllCourses(List<? extends CourseType> courseTypes) {

        System.out.println("Course Evaluation Methods:");
        for (CourseType type : courseTypes) {
            type.evaluate();
        }
    }
}
