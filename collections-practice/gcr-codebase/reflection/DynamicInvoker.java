import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicInvoker {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter method name (add / subtract / multiply): ");
        String methodName = sc.nextLine();

        System.out.print("Enter first number: ");
        int x = sc.nextInt();

        System.out.print("Enter second number: ");
        int y = sc.nextInt();

        // Step 1: Load class dynamically
        Class<?> cls = Class.forName("MathOperations");

        // Step 2: Create object dynamically
        Object obj = cls.getDeclaredConstructor().newInstance();

        // Step 3: Get method based on user input
        Method method = cls.getMethod(methodName, int.class, int.class);

        // Step 4: Invoke method dynamically
        Object result = method.invoke(obj, x, y);

        // Step 5: Print result
        System.out.println("Result: " + result);
    }
}
