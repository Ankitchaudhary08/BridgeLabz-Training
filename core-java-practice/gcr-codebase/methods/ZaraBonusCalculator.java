import java.util.Random;

public class ZaraBonusCalculator {

    // this method generate random salary and year of service
    public static double[][] generateEmployeeData(int size) {

        double[][] data = new double[size][2];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {

            // generating random 5 digit salary
            data[i][0] = 10000 + rand.nextInt(90000);

            // generating random year of service between 1 to 10
            data[i][1] = 1 + rand.nextInt(10);
        }

        return data;
    }

    // this method calculate new salary and bonus
    public static double[][] calculateBonus(double[][] empData) {

        double[][] result = new double[empData.length][2];

        for (int i = 0; i < empData.length; i++) {

            double salary = empData[i][0];
            double years = empData[i][1];
            double bonus;

            // checking service years condition
            if (years > 5) {
                bonus = salary * 0.05;   // 5 percent bonus
            } else {
                bonus = salary * 0.02;   // 2 percent bonus
            }

            double newSalary = salary + bonus;

            result[i][0] = newSalary;
            result[i][1] = bonus;
        }

        return result;
    }

    // this method calculate total salaries and bonus
    public static void calculateTotals(double[][] oldData, double[][] newData) {

        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        // calculating totals
        for (int i = 0; i < oldData.length; i++) {
            totalOldSalary += oldData[i][0];
            totalNewSalary += newData[i][0];
            totalBonus += newData[i][1];
        }

        // displaying final result in table format
        System.out.println("\n------------ Final Salary Summary ------------");
        System.out.printf("%-20s %.2f\n", "Total Old Salary:", totalOldSalary);
        System.out.printf("%-20s %.2f\n", "Total Bonus Paid:", totalBonus);
        System.out.printf("%-20s %.2f\n", "Total New Salary:", totalNewSalary);
    }

    public static void main(String[] args) {

        int employees = 10;

        // generating salary and service data
        double[][] employeeData = generateEmployeeData(employees);

        // calculating bonus and new salary
        double[][] updatedData = calculateBonus(employeeData);

        // displaying each employee details
        System.out.println("Emp\tOldSalary\tYears\tBonus\t\tNewSalary");
        System.out.println("------------------------------------------------------");

        for (int i = 0; i < employees; i++) {
            System.out.printf(
                    "%d\t%.2f\t%.0f\t%.2f\t%.2f\n",
                    (i + 1),
                    employeeData[i][0],
                    employeeData[i][1],
                    updatedData[i][1],
                    updatedData[i][0]
            );
        }

        // displaying total summary
        calculateTotals(employeeData, updatedData);
    }
}
