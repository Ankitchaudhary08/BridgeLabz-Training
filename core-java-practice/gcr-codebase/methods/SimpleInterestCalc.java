import java.util.Scanner;

public class SimpleInterestCalc {

    // this method calculate simple intrest using given values
    public static double getSimpleInterest(double principle, double rate, double time) {

        // applying simple interest formula
        double siValue = (principle * rate * time) / 100;

        return siValue;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking principal amount from user
        System.out.print("Enter Principal: ");
        double principal = sc.nextDouble();

        // taking rate of intrest
        System.out.print("Enter Rate of Interest: ");
        double rate = sc.nextDouble();

        // taking time period from user
        System.out.print("Enter Time: ");
        double time = sc.nextDouble();

        // calling method to calculate si
        double result = getSimpleInterest(principal, rate, time);

        // displaying final result
        System.out.println(
                "The Simple Interest is " + result +
                " for Principal " + principal +
                ", Rate of Interest " + rate +
                " and Time " + time
        );

        sc.close();
    }
}
