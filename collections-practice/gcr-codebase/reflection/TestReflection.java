import java.lang.reflect.Field;

class Person {

    // private field
    private int age = 20;

}

public class TestReflection {

    public static void main(String[] args) throws Exception {

        // Create object of Person
        Person p = new Person();

        // Get Class object
        Class<?> cls = p.getClass();

        // Access private field "age"
        Field field = cls.getDeclaredField("age");

        // Make private field accessible
        field.setAccessible(true);

        // Modify value of age
        field.set(p, 25);

        // Retrieve value of age
        int ageValue = (int) field.get(p);

        // Print value
        System.out.println("Age is: " + ageValue);
    }
}
