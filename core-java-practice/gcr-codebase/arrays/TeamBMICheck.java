import java.util.Scanner;

public class TeamBMICheck {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter total number of team members: ");
        int totalMembers = input.nextInt();

        double[] heights = new double[totalMembers];
        double[] weights = new double[totalMembers];
        double[] bmiValues = new double[totalMembers];
        String[] healthStatus = new String[totalMembers];

        // Taking height and weight input
        for (int index = 0; index < totalMembers; index++) {
            System.out.println("\nMember " + (index + 1));

            System.out.print("Height (meters): ");
            heights[index] = input.nextDouble();

            System.out.print("Weight (kg): ");
            weights[index] = input.nextDouble();
        }

        // BMI calculation and status assignment
        for (int index = 0; index < totalMembers; index++) {
            bmiValues[index] = weights[index] / Math.pow(heights[index], 2);

            if (bmiValues[index] < 18.5) {
                healthStatus[index] = "Underweight";
            } else if (bmiValues[index] < 25) {
                healthStatus[index] = "Normal";
            } else if (bmiValues[index] < 40) {
                healthStatus[index] = "Overweight";
            } else {
                healthStatus[index] = "Obese";
            }
        }

        // Displaying final result
        System.out.println("\n===== TEAM BMI DETAILS =====");
        for (int index = 0; index < totalMembers; index++) {
            System.out.println("Member " + (index + 1));
            System.out.println("Height : " + heights[index] + " m");
            System.out.println("Weight : " + weights[index] + " kg");
            System.out.println("BMI    : " + bmiValues[index]);
            System.out.println("Status : " + healthStatus[index]);
            System.out.println("----------------------------");
        }

       
    }
}
