
import java.util.Scanner; 

public class CelsiusToFahrenheit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 

        // temperature in celsius
        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble(); 

        // Convert to fehrenhiet
        double fahrenheit = (celsius * 9 / 5) + 32;

        // result
        System.out.println("Temperature in Fahrenheit: " + fahrenheit);
    }
}
