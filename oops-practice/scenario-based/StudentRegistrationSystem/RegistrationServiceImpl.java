package StudentRegistrationSystem;
public class RegistrationServiceImpl implements RegistrationService {

    private static final int MAX_COURSES = 3;

    @Override
    public void enrollCourse(Student student, String course)
            throws CourseLimitExceededException {

        if (student.getCourses().size() >= MAX_COURSES) {
            throw new CourseLimitExceededException("Course limit exceeded");
        }

        student.addCourse(course);
        System.out.println("Enrolled in course: " + course);
    }

    @Override
    public void dropCourse(Student student, String course) {
        student.removeCourse(course);
        System.out.println("Dropped course: " + course);
    }
}
