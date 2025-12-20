import java.util.*;
public class YoungestTallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Amar
        System.out.print("Enter Amar's Age: ");
        int ageAmar = scanner.nextInt();
        System.out.print("Enter Amar's Height: ");
        int heightAmar = scanner.nextInt();

        // Input for Akbar
        System.out.print("Enter Akbar's Age: ");
        int ageAkbar = scanner.nextInt();
        System.out.print("Enter Akbar's Height: ");
        int heightAkbar = scanner.nextInt();

        // Input for Anthony
        System.out.print("Enter Anthony's Age: ");
        int ageAnthony = scanner.nextInt();
        System.out.print("Enter Anthony's Height: ");
        int heightAnthony = scanner.nextInt();

        // Find Youngest
        int minAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        if (minAge == ageAmar) {
            System.out.println("Amar is the youngest.");
        } else if (minAge == ageAkbar) {
            System.out.println("Akbar is the youngest.");
        } else {
            System.out.println("Anthony is the youngest.");
        }

        // Find Tallest
        int maxHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));
        if (maxHeight == heightAmar) {
            System.out.println("Amar is the tallest.");
        } else if (maxHeight == heightAkbar) {
            System.out.println("Akbar is the tallest.");
        } else {
            System.out.println("Anthony is the tallest.");
        }
        
    }
}