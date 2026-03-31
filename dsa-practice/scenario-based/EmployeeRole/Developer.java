// Developer role
class Developer extends Employee {

    public Developer(String name, double salary) {
        super(name, salary);
    }

    // Developer gets bonus only if salary is above 50,000
    @Override
    protected double calculateBonus() {
        return getSalary() > 50000 ? getSalary() * 0.05 : 0.0;
    }
}
