public class Main {
    public static void main(String[] args) {

        // Creating a savings account object
        BankAccount savings = new SavingsAccount("12345", 1000.0);
        System.out.printf("%.2f%n", savings.calculateFee());

        // Savings account with smaller balance
        BankAccount savings2 = new SavingsAccount("11111", 500.0);
        System.out.printf("%.2f%n", savings2.calculateFee());

        // Checking account with high balance (no fee)
        BankAccount checking1 = new CheckingAccount("22222", 1500.0);
        System.out.printf("%.2f%n", checking1.calculateFee());

        // Checking account with low balance (flat fee)
        BankAccount checking2 = new CheckingAccount("33333", 500.0);
        System.out.printf("%.2f%n", checking2.calculateFee());
    }
}
