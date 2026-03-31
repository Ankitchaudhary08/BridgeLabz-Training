import java.lang.reflect.Constructor;

class Student {

    private int id;
    private String name;

    // No-argument constructor
    public Student() {
        this.id = 1;
        this.name = "Ankit";
    }

    public void display() {
        System.out.println("Id: " + id + ", Name: " + name);
    }
}

public class TestReflection2 {

    public static void main(String[] args) throws Exception {

        // Step 1: Load class dynamically
        Class<?> cls = Class.forName("Student");

        // Step 2: Get constructor
        Constructor<?> constructor = cls.getDeclaredConstructor();

        // Step 3: Create object dynamically (without new keyword)
        Object obj = constructor.newInstance();

        // Step 4: Cast object
        Student s = (Student) obj;

        // Step 5: Call method
        s.display();
    }
}
