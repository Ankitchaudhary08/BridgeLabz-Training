import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define double arrays to save salary and years of service for each of the 10 employees
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];

        // Define double arrays to save the new salary and the bonus amount
        double[] bonusAmounts = new double[10];
        double[] newSalaries = new double[10];

        // Variables to save the total bonus, total old salary, and new salary
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        System.out.println("Enter details for 10 employees:");

        // Define a loop to take input from the user
        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1) + ":");
            System.out.print("Enter base salary: ");
            double salary = sc.nextDouble();
            System.out.print("Enter years of service: ");
            double years = sc.nextDouble();

            // If salary or year of service is an invalid number then ask the use to enter again
            if (salary <= 0 || years < 0) {
                System.out.println("Invalid input. Salary must be positive and years non-negative. Please try again.");
                // Decrement the index counter to retry this iteration
                i--;
                continue;
            }

            salaries[i] = salary;
            yearsOfService[i] = years;
        }

        // Define another loop to calculate the bonus of 10 employees
        for (int i = 0; i < 10; i++) {
            // Bonus of 5% if years > 5, else 2%
            double bonusPercentage = (yearsOfService[i] > 5) ? 0.05 : 0.02;
            
            // Save the bonus in the array
            bonusAmounts[i] = salaries[i] * bonusPercentage;
            
            // Compute the new salary and save in the array
            newSalaries[i] = salaries[i] + bonusAmounts[i];

            // Calculate totals in the loop
            totalOldSalary += salaries[i];
            totalBonus += bonusAmounts[i];
            totalNewSalary += newSalaries[i];
        }

        // Print the total bonus payout as well as the total old and new salary
        System.out.println("\nTotal Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}