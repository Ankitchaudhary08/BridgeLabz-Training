import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToStudent {

    // 1️⃣ Student class
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

        void printStudent() {
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

        // 2️⃣ List to store Student objects
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // 3️⃣ Skip header row
            br.readLine();

            // 4️⃣ Read each CSV row
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);

                // 5️⃣ Create Student object
                Student student = new Student(id, name, age, marks);

                // 6️⃣ Add to list
                students.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 7️⃣ Print all students
        System.out.println("Student Records:");
        System.out.println("----------------");

        for (Student s : students) {
            s.printStudent();
        }
    }
}
