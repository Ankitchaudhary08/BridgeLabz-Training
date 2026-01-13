package StudentRegistrationSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Person {

    private String studentId;
    private ArrayList<String> courses;
    private HashMap<String, String> grades;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
        this.courses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void removeCourse(String course) {
        courses.remove(course);
    }

    public void addGrade(String course, String grade) {
        grades.put(course, grade);
    }

    public void viewGrades() {
        System.out.println("Grades:");
        for (String course : grades.keySet()) {
            System.out.println(course + " : " + grades.get(course));
        }
    }
}
