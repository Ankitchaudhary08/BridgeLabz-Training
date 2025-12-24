import java.util.Scanner;

public class BMICalculator {

    // this method calculate bmi for all persons and store in array
    public static void calculateBMI(double[][] data) {

        for (int i = 0; i < data.length; i++) {

            // converting height from cm to meter
            double heightInMeter = data[i][1] / 100;

            // bmi formula
            double bmi = data[i][0] / (heightInMeter * heightInMeter);

            data[i][2] = bmi;
        }
    }

    // this method find bmi status of each person
    public static String[] findBMIStatus(double[][] data) {

        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {

            double bmi = data[i][2];

            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi >= 25.0 && bmi <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        return status;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 2D array : 10 rows and 3 columns
        // col 0 -> weight, col 1 -> height, col 2 -> bmi
        double[][] personData = new double[10][3];

        // taking weight and height from user
        for (int i = 0; i < personData.length; i++) {
            System.out.println("Enter details of person " + (i + 1));

            System.out.print("Weight (kg): ");
            personData[i][0] = sc.nextDouble();

            System.out.print("Height (cm): ");
            personData[i][1] = sc.nextDouble();
        }

        // calculating bmi for all
        calculateBMI(personData);

        // getting bmi status
        String[] bmiStatus = findBMIStatus(personData);

        // displaying final output
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < personData.length; i++) {
            System.out.println(
                    "Person " + (i + 1) +
                    " | Weight: " + personData[i][0] +
                    " | Height: " + personData[i][1] +
                    " | BMI: " + personData[i][2] +
                    " | Status: " + bmiStatus[i]
            );
        }

        sc.close();
    }
}
