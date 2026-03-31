import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

public class LogExecutionTimeDemo {

    // Step 1: Create Annotation
    @Retention(RetentionPolicy.RUNTIME)    // Needed for Reflection
    @Target(ElementType.METHOD)             // Only for methods
    @interface LogExecutionTime {
    }

    // Step 2: Class with Methods
    static class PerformanceTest {

        @LogExecutionTime
        public void fastMethod() {
            for (int i = 0; i < 1000; i++) {
                // fast loop
            }
        }

        @LogExecutionTime
        public void slowMethod() {
            for (int i = 0; i < 1000000; i++) {
                // slow loop
            }
        }

        public void normalMethod() {
            System.out.println("Normal method (no logging)");
        }
    }

    // Step 3: Main Method – Measure Time using Reflection
    public static void main(String[] args) throws Exception {

        PerformanceTest obj = new PerformanceTest();
        Class<?> cls = obj.getClass();

        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long startTime = System.nanoTime();

                // Invoke method
                method.invoke(obj);

                long endTime = System.nanoTime();

                long executionTime = endTime - startTime;

                System.out.println(
                        "Method: " + method.getName() +
                        " | Execution Time: " + executionTime + " ns"
                );
            }
        }
    }
}
