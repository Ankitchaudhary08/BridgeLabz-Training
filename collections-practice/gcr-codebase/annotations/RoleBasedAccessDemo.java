import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

public class RoleBasedAccessDemo {

    // Step 1: Create @RoleAllowed Annotation
    @Retention(RetentionPolicy.RUNTIME)   // Needed for Reflection
    @Target(ElementType.TYPE)             // Class-level annotation
    @interface RoleAllowed {
        String value();                   // Allowed role
    }

    // Step 2: Secure Class with Role Restriction
    @RoleAllowed("ADMIN")
    static class AdminService {

        public void deleteUser() {
            System.out.println("User deleted successfully!");
        }
    }

    // Step 3: Simulate Role-Based Access
    public static void main(String[] args) throws Exception {

        // Simulated user role
        String currentUserRole = "USER";  // Try changing to "ADMIN"

        AdminService service = new AdminService();
        Class<?> cls = service.getClass();

        // Check if class has @RoleAllowed
        if (cls.isAnnotationPresent(RoleAllowed.class)) {

            RoleAllowed roleAllowed = cls.getAnnotation(RoleAllowed.class);
            String allowedRole = roleAllowed.value();

            if (allowedRole.equals(currentUserRole)) {

                // Role matched → allow access
                Method method = cls.getMethod("deleteUser");
                method.invoke(service);

            } else {
                // Role not matched
                System.out.println("Access Denied!");
            }
        }
    }
}
