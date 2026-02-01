public class EmployeeWageComputation {

    // Class variables
    public static final int IS_ABSENT = 0;
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    public static final int WAGE_PER_HOUR = 20;
    public static final int FULL_DAY_HOURS = 8;
    public static final int PART_TIME_HOURS = 8;
    public static final int WORKING_DAYS_PER_MONTH = 20;
    public static final int MAX_WORKING_HOURS = 100;

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");

        int totalWorkingHours = 0;
        int totalWorkingDays = 0;
        int totalWage = 0;

        // UC6: calculate wage till condition reached
        while (totalWorkingHours < MAX_WORKING_HOURS
                && totalWorkingDays < WORKING_DAYS_PER_MONTH) {

            totalWorkingDays++;

            // UC1: attendance check
            int empCheck = (int) (Math.random() * 3);
            int empHours = 0;

            // UC4: switch case
            switch (empCheck) {
                case IS_FULL_TIME:
                    empHours = FULL_DAY_HOURS;
                    break;

                case IS_PART_TIME:
                    empHours = PART_TIME_HOURS;
                    break;

                default:
                    empHours = 0;
            }

            // UC2 & UC3: daily wage calculation
            int dailyWage = empHours * WAGE_PER_HOUR;
            totalWorkingHours += empHours;
            totalWage += dailyWage;

            System.out.println("Day " + totalWorkingDays +
                    " | Hours Worked: " + empHours +
                    " | Daily Wage: " + dailyWage);
        }

        // UC5: monthly wage
        System.out.println("Total Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Monthly Wage: " + totalWage);
    }
}
