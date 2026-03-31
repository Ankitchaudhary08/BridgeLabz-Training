import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

public class TodoAnnotationDemo {

    // Step 1: Define @Todo Annotation
    @Retention(RetentionPolicy.RUNTIME)   // Needed for Reflection
    @Target(ElementType.METHOD)            // Only for methods
    @interface Todo {
        String task();                     // Task description
        String assignedTo();               // Developer name
        String priority() default "MEDIUM"; // Default value
    }

    // Step 2: Apply Annotation to Methods
    static class ProjectService {

        @Todo(
            task = "Implement login feature",
            assignedTo = "Ankit",
            priority = "HIGH"
        )
        public void login() { }

        @Todo(
            task = "Add payment gateway",
            assignedTo = "Rahul"
        )
        public void payment() { }

        @Todo(
            task = "Improve UI design",
            assignedTo = "Neha",
            priority = "LOW"
        )
        public void uiUpdate() { }

        public void completedTask() { }
    }

    // Step 3: Retrieve Annotations using Reflection
    public static void main(String[] args) {

        Class<ProjectService> cls = ProjectService.class;
        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(Todo.class)) {

                Todo todo = method.getAnnotation(Todo.class);

                System.out.println("Method     : " + method.getName());
                System.out.println("Task       : " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority   : " + todo.priority());
                System.out.println("---------------------------");
            }
        }
    }
}
