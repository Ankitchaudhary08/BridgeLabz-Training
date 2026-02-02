import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

public class CustomAnnotationExample {

    // Step 1: Create Custom Annotation
    @Retention(RetentionPolicy.RUNTIME)   // Needed for Reflection
    @Target(ElementType.METHOD)            // Can be applied to methods
    @interface TaskInfo {
        String priority();
        String assignedTo();
    }

    // Step 2: Use Annotation on a Method
    static class TaskManager {

        @TaskInfo(priority = "High", assignedTo = "Ankit")
        public void completeTask() {
            System.out.println("Task is being completed...");
        }
    }

    // Step 3: Retrieve Annotation using Reflection
    public static void main(String[] args) throws Exception {

        TaskManager manager = new TaskManager();

        // Get Class object
        Class<?> cls = manager.getClass();

        // Get Method object
        Method method = cls.getMethod("completeTask");

        // Check if annotation is present
        if (method.isAnnotationPresent(TaskInfo.class)) {

            // Get annotation
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

            // Print annotation values
            System.out.println("Priority   : " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }

        // Call method
        manager.completeTask();
    }
}
