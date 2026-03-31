import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

public class ImportantMethodDemo {

    // Step 1: Define Custom Annotation
    @Retention(RetentionPolicy.RUNTIME)      // Needed for Reflection
    @Target(ElementType.METHOD)               // Only for methods
    @interface ImportantMethod {
        String level() default "HIGH";        // Optional parameter
    }

    // Step 2: Apply Annotation to Methods
    static class Service {

        @ImportantMethod
        public void saveData() {
            System.out.println("Saving data...");
        }

        @ImportantMethod(level = "MEDIUM")
        public void updateData() {
            System.out.println("Updating data...");
        }

        public void normalMethod() {
            System.out.println("Normal method");
        }
    }

    // Step 3: Retrieve Annotation using Reflection
    public static void main(String[] args) {

        Class<Service> cls = Service.class;
        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(ImportantMethod.class)) {

                ImportantMethod im = method.getAnnotation(ImportantMethod.class);

                System.out.println(
                    "Method Name: " + method.getName() +
                    ", Level: " + im.level()
                );
            }
        }
    }
}
