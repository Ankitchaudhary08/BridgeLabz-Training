import java.util.Scanner;

public class MultiplesOfNumberWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive number less than 100.");
        } else {
            int counter = number;

            System.out.print("Multiples of " + number + " below 100 are: ");

            while (counter < 100) {
                System.out.print(counter + " ");
                counter = counter + number;
            }
        }
    }
}
