// Manager role
class Manager extends Employee {

    public Manager(String name, double salary) {
        super(name, salary);
    }

    // Manager bonus is always 10% of salary
    @Override
    protected double calculateBonus() {
        return getSalary() * 0.10;
    }
}
