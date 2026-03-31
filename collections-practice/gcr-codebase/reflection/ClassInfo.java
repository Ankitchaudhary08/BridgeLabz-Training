import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInfo {

    public static void main(String[] args) {

        try {
            // Take class name as input
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter class name (example: java.util.ArrayList): ");
            String className = sc.nextLine();

            // Load class dynamically
            Class<?> cls = Class.forName(className);

            // Print class name
            System.out.println("\nClass Name: " + cls.getName());

            // ---------- Methods ----------
            System.out.println("\nMethods:");
            Method[] methods = cls.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m.getName());
            }

            // ---------- Fields ----------
            System.out.println("\nFields:");
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                System.out.println(f.getName());
            }

            // ---------- Constructors ----------
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> c : constructors) {
                System.out.println(c.getName());
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        }
    }
}
