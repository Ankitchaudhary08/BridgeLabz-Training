import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    // Method to generate ArrayIndexOutOfBoundsException
    static void generateException(String[] names) {
        // Accessing index beyond array length
        System.out.println(names[names.length]);
    }

    // Method to handle ArrayIndexOutOfBoundsException
    static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int n = sc.nextInt();

        String[] names = new String[n];

        System.out.println("Enter names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        // Call method to generate exception
        generateException(names);

        // Call method to handle exception
        handleException(names);
    }
}
