// Loan interface
interface Loanable {
    void applyForLoan();
    double calculateLoanEligibility();
}

// Abstract BankAccount class
abstract class BankAccount {

    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation: getters
    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited: " + amount);
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Abstract method
    public abstract double calculateInterest();
}

// Savings Account
class SavingsAccount extends BankAccount implements Loanable {

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan() {
        System.out.println("Loan applied for Savings Account");
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 2;
    }
}

// Current Account
class CurrentAccount extends BankAccount implements Loanable {

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02; // 2% interest
    }

    @Override
    public void applyForLoan() {
        System.out.println("Loan applied for Current Account");
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 3;
    }
}

// Main class
public class BankingSystem {

    public static void main(String[] args) {

        BankAccount acc1 = new SavingsAccount("SA101", "Ankit", 50000);
        BankAccount acc2 = new CurrentAccount("CA202", "Rahul", 80000);

        BankAccount[] accounts = { acc1, acc2 };

        for (BankAccount acc : accounts) {
            System.out.println("Interest: " + acc.calculateInterest());

            Loanable loan = (Loanable) acc;
            loan.applyForLoan();
            System.out.println("Loan Eligibility: " + loan.calculateLoanEligibility());
            System.out.println("----------------------");
        }
    }
}
