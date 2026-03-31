import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

public class MaxLengthValidationDemo {

    // Step 1: Create @MaxLength Annotation
    @Retention(RetentionPolicy.RUNTIME)   // Needed for Reflection
    @Target(ElementType.FIELD)             // Only for fields
    @interface MaxLength {
        int value();                       // Maximum allowed length
    }

    // Step 2: User Class with Validation
    static class User {

        @MaxLength(10)     // Username max length = 10
        private String username;

        public User(String username) {

            // Validate using Reflection
            try {
                Field field = this.getClass().getDeclaredField("username");
                field.setAccessible(true);

                if (field.isAnnotationPresent(MaxLength.class)) {

                    MaxLength maxLength = field.getAnnotation(MaxLength.class);
                    int limit = maxLength.value();

                    if (username.length() > limit) {
                        throw new IllegalArgumentException(
                            "Username length should not exceed " + limit
                        );
                    }
                }

                // Set value if validation passes
                this.username = username;

            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

        public String getUsername() {
            return username;
        }
    }

    // Step 3: Test
    public static void main(String[] args) {

        // Valid username
        User user1 = new User("Ankit");
        System.out.println("Username: " + user1.getUsername());

        // Invalid username (length > 10)
        User user2 = new User("VeryLongUsername"); // Exception
        System.out.println("Username: " + user2.getUsername());
    }
}
