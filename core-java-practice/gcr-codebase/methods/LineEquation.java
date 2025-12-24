import java.util.Scanner;

public class LineEquation {

    // this method calculate euclidean distance between two points
    public static double findDistance(double x1, double y1, double x2, double y2) {

        double dx = Math.pow(x2 - x1, 2);
        double dy = Math.pow(y2 - y1, 2);

        // applying distance formula
        double distance = Math.sqrt(dx + dy);

        return distance;
    }

    // this method find slope and y-intercept of line
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {

        double[] result = new double[2];

        // slope calculation
        double m = (y2 - y1) / (x2 - x1);

        // y-intercept calculation
        double b = y1 - m * x1;

        result[0] = m;
        result[1] = b;

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking input for first point
        System.out.print("Enter x1 y1: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        // taking input for second point
        System.out.print("Enter x2 y2: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        double distance = findDistance(x1, y1, x2, y2);
        double[] equation = findLineEquation(x1, y1, x2, y2);

        // displaying output
        System.out.println("\nEuclidean Distance = " + distance);
        System.out.println("Equation of Line: y = " + equation[0] + "x + " + equation[1]);

        sc.close();
    }
}
