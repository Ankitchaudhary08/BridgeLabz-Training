import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Step 1: Create Custom Annotation
@Retention(RetentionPolicy.RUNTIME)   // Runtime par available
@Target(ElementType.TYPE)             // Sirf class par use hogi
@interface Author {
    String name();
}

// Step 2: Apply Annotation to a Class
@Author(name = "Ankit Chaudhary")
class MyBook {
    // class body
}

// Step 3: Read Annotation at Runtime using Reflection
public class AnnotationRuntimeDemo {

    public static void main(String[] args) {

        // Get Class object
        Class<MyBook> cls = MyBook.class;

        // Check if annotation is present
        if (cls.isAnnotationPresent(Author.class)) {

            // Retrieve annotation
            Author author = cls.getAnnotation(Author.class);

            // Print annotation value
            System.out.println("Author Name: " + author.name());
        }
    }
}
