import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take first number
        System.out.print("Enter first number: ");
        double number1 = sc.nextDouble();

        // Take second number
        System.out.print("Enter second number: ");
        double number2 = sc.nextDouble();

        // Perform calculations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;

        // Print result
        System.out.println(
            "The addition, subtraction, multiplication and division value of 2 numbers "
            + number1 + " and " + number2 + " is "
            + addition + ", " + subtraction + ", " + multiplication + ", and " + division
        );
    }
}
