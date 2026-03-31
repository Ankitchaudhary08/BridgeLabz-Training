import java.util.Scanner;

public class WindChillCalculator {

    // this method calculate wind chill tempreture
    public static double calculateWindChill(double temperature, double windSpeed) {

        // applying wind chill formula
        double windChill = 35.74 
                + 0.6215 * temperature 
                + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);

        return windChill;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking temperature from user
        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();

        // taking wind speed
        System.out.print("Enter wind speed: ");
        double speed = sc.nextDouble();

        // calling method
        double result = calculateWindChill(temp, speed);

        // printing final result
        System.out.println("Wind Chill Temperature is " + result);

        sc.close();
    }
}
