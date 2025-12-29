import java.util.Scanner;

public class TempConverter {

    static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();

        System.out.print("Convert to (C/F): ");
        char ch = sc.next().charAt(0);

        if (ch == 'C') {
            System.out.println("In Celsius: " + fahrenheitToCelsius(temp));
        } else if (ch == 'F') {
            System.out.println("In Fahrenheit: " + celsiusToFahrenheit(temp));
        }

        sc.close();
    }
}
