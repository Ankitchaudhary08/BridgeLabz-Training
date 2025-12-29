public class EmployeeWageComputation {

    // class variables (constants)
    static final int IS_PART_TIME = 1;
    static final int IS_FULL_TIME = 2;

    static final int WAGE_PER_HOUR = 20;
    static final int FULL_DAY_HOUR = 8;
    static final int PART_TIME_HOUR = 8; // as given in problem

    static final int MAX_WORKING_DAYS = 20;
    static final int MAX_WORKING_HOURS = 100;

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        int totalWorkingDays = 0;
        int totalWorkingHours = 0;
        int totalWage = 0;

        // UC5: calculate wage till max hours or days reached
        while (totalWorkingDays < MAX_WORKING_DAYS &&
               totalWorkingHours < MAX_WORKING_HOURS) {

            totalWorkingDays++;

            // UC1: check employee attendance using RANDOM
            int empCheck = (int) (Math.random() * 3);
            int empHours = 0;

            // UC4: solve using switch case
            switch (empCheck) {

                case IS_FULL_TIME:
                    empHours = FULL_DAY_HOUR;
                    break;

                case IS_PART_TIME:
                    empHours = PART_TIME_HOUR;
                    break;

                default:
                    empHours = 0; // employee absent
            }

            totalWorkingHours = totalWorkingHours + empHours;

            // UC2 & UC3: calculate daily wage
            int dailyWage = empHours * WAGE_PER_HOUR;
            totalWage = totalWage + dailyWage;

            System.out.println(
                "Day " + totalWorkingDays +
                " | Work Hours: " + empHours +
                " | Daily Wage: ₹" + dailyWage
            );
        }

        // UC5: monthly result
        System.out.println("--------------------------------");
        System.out.println("Total Working Days : " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Monthly Wage : ₹" + totalWage);

        // program ends here
    }
}
