// Generic Course class
// T must be a type of CourseType
public class Course<T extends CourseType> {

    private String courseName;
    private T courseType;

    // Constructor
    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    // Display course details
    public void showCourse() {
        System.out.println("Course: " + courseName);
        courseType.evaluate();
    }

    public T getCourseType() {
        return courseType;
    }
}
