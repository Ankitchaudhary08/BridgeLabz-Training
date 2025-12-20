import java.util.*;

public class FactorsUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int number = sc.nextInt();
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int counter = 1;

            System.out.print("Factors of " + number + " are: ");

            while (counter <= number) {
                if (number % counter == 0) {
                    System.out.print(counter + " ");
                }
                counter++;
            }
        }
    }
}
