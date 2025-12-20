import java.util.Scanner;

public class BMIMultiDimArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        // 2D array: [height, weight, BMI]
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Input height and weight with validation
        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1));

            // Height input validation
            do {
                System.out.print("Enter height (in meters): ");
                personData[i][0] = sc.nextDouble();
            } while (personData[i][0] <= 0);

            // Weight input validation
            do {
                System.out.print("Enter weight (in kg): ");
                personData[i][1] = sc.nextDouble();
            } while (personData[i][1] <= 0);
        }

        // Calculate BMI and determine status
        for (int i = 0; i < number; i++) {
            double height = personData[i][0];
            double weight = personData[i][1];

            personData[i][2] = weight / (height * height); // BMI

            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display result
        System.out.println("\n----- BMI REPORT -----");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Height : " + personData[i][0] + " m");
            System.out.println("Weight : " + personData[i][1] + " kg");
            System.out.println("BMI    : " + personData[i][2]);
            System.out.println("Status : " + weightStatus[i]);
            System.out.println("----------------------");
        }

        
    }
}
