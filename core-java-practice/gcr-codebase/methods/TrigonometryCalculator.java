import java.util.Scanner;

public class TrigonometryCalculator {

    // this method calculate sine cosine and tangent
    public static double[] calculateTrigonometricFunctions(double angle) {

        // converting degree to radian
        double radian = Math.toRadians(angle);

        double sine = Math.sin(radian);
        double cosine = Math.cos(radian);
        double tangent = Math.tan(radian);

        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking angle from user
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();

        // calling method
        double[] result = calculateTrigonometricFunctions(angle);

        // printing results
        System.out.println("Sine value is " + result[0]);
        System.out.println("Cosine value is " + result[1]);
        System.out.println("Tangent value is " + result[2]);

        sc.close();
    }
}
