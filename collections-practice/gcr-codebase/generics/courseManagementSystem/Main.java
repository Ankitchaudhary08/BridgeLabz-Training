import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Creating different courses
        Course<ExamCourse> math =
                new Course<>("Mathematics", new ExamCourse());

        Course<AssignmentCourse> programming =
                new Course<>("Programming", new AssignmentCourse());

        Course<ResearchCourse> aiResearch =
                new Course<>("AI Research", new ResearchCourse());

        // Display individual course details
        math.showCourse();
        programming.showCourse();
        aiResearch.showCourse();

        // Store different course types together
        List<CourseType> courseTypes = new ArrayList<>();
        courseTypes.add(new ExamCourse());
        courseTypes.add(new AssignmentCourse());
        courseTypes.add(new ResearchCourse());

        // Display using wildcard method
        CourseUtil.displayAllCourses(courseTypes);
    }
}
