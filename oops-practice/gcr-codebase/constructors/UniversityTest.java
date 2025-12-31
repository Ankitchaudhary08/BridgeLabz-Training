class Student {
    // Access modifiers
    public int rollNumber;
    protected String name;
    private double cgpa;

    // Constructor
    Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    // Public method to get CGPA
    public double getCGPA() {
        return cgpa;
    }

    // Public method to update CGPA
    public void setCGPA(double cgpa) {
        if (cgpa >= 0.0 && cgpa <= 10.0) {
            this.cgpa = cgpa;
        } else {
            System.out.println("Invalid CGPA value");
        }
    }

    // Display student details
    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + cgpa);
    }
}

public class UniversityTest {
    public static void main(String[] args) {

        Student s1 = new Student(101, "Ankit", 8.2);

        s1.displayDetails();

        System.out.println("\nUpdating CGPA...");
        s1.setCGPA(8.7);

        System.out.println("Updated CGPA: " + s1.getCGPA());
    }
}
