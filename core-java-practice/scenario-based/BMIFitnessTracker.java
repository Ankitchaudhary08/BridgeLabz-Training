import java.util.*;
public class BMIFitnessTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Height
        System.out.print("Enter height in meters: ");
        double heightInMeters = sc.nextDouble();

        //Weight
        System.out.print("Enter weight in kilograms: ");
        double weightInKg = sc.nextDouble();

        // BMI formula
        double bmi = weightInKg / (heightInMeters * heightInMeters);

        // Print BMI value
        System.out.println("Your BMI is: " + bmi);

        // BMI category using if-else
        if (bmi < 18.5) {
            System.out.println("Category: Underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("Category: Normal");
        } else {
            System.out.println("Category: Overweight");
        }

       
    }
}
