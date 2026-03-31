import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToStudentObjects {

    // Student class
    static class Student {
        int id;
        String name;
        int age;
        int marks;

        Student(int id, String name, int age, int marks) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.marks = marks;
        }

        void display() {
            System.out.println(
                "ID: " + id +
                ", Name: " + name +
                ", Age: " + age +
                ", Marks: " + marks
            );
        }
    }

    public static void main(String[] args) {

        String filePath = "students.csv";
        String line;

        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // 1️⃣ Skip header
            br.readLine();

            // 2️⃣ Read each record
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);

                // 3️⃣ Create Student object
                Student student = new Student(id, name, age, marks);

                // 4️⃣ Add to list
                students.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5️⃣ Print student objects
        System.out.println("Student Records:");
        System.out.println("----------------");

        for (Student s : students) {
            s.display();
        }
    }
}
