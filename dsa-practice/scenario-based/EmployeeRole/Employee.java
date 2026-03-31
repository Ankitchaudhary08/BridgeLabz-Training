// Abstract base class for all employees
abstract class Employee {

    // Name should not change after creation
    private final String name;

    // Salary is fixed to keep employee data immutable
    private final double salary;

    // Cached bonus value for performance
    private final double bonus;

    // Constructor initializes common data and bonus
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.bonus = calculateBonus(); // calculated once
    }

    // Getter for salary (used by subclasses)
    protected double getSalary() {
        return salary;
    }

    // Each role calculates bonus differently
    protected abstract double calculateBonus();

    // Public method to get already calculated bonus
    public double getBonus() {
        return bonus;
    }
}
