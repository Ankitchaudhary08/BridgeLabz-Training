class Student {

    // Static variables
    static String universityName = "Global University";
    static int totalStudents = 0;

    // Instance variables
    final int rollNumber;   // final variable
    String name;
    String grade;

    // Constructor using this
    Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    // Static method
    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Method using instanceof to display details
    void displayDetails(Object obj) {
        if (obj instanceof Student) {
            Student s = (Student) obj;
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + s.rollNumber);
            System.out.println("Name: " + s.name);
            System.out.println("Grade: " + s.grade);
            System.out.println();
        }
    }

    // Method to update grade using instanceof
    void updateGrade(Object obj, String newGrade) {
        if (obj instanceof Student) {
            Student s = (Student) obj;
            s.grade = newGrade;
            System.out.println("Grade updated to: " + newGrade);
        }
    }

    // Main method
    public static void main(String[] args) {

        Student s1 = new Student(101, "Hemashree", "A");
        Student s2 = new Student(102, "Sharmila", "B");

        displayTotalStudents();

        s1.displayDetails(s1);
        s2.displayDetails(s2);

        s2.updateGrade(s2, "A");

        s2.displayDetails(s2);
    }
}
