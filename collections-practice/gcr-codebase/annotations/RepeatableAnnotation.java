import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

public class RepeatableAnnotation {

    // Step 1: Container Annotation
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface BugReports {
        BugReport[] value();
    }

    // Step 2: Repeatable Annotation
    @Repeatable(BugReports.class)
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface BugReport {
        String description();
    }

    // Step 3: Use Annotation Multiple Times
    static class TaskService {

        @BugReport(description = "NullPointerException when input is null")
        @BugReport(description = "Performance issue with large data")
        public void processTask() {
            System.out.println("Processing task...");
        }
    }

    // Step 4: Retrieve Annotations using Reflection
    public static void main(String[] args) throws Exception {

        Class<TaskService> cls = TaskService.class;
        Method method = cls.getMethod("processTask");

        // Get all BugReport annotations
        BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);

        for (BugReport bug : bugReports) {
            System.out.println("Bug: " + bug.description());
        }

        // Call method
        new TaskService().processTask();
    }
}
