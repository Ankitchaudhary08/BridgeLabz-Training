// Parent class
class BankAccount {
    // Access modifiers
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    // Constructor
    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to get balance
    public double getBalance() {
        return balance;
    }

    // Public method to update balance
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance amount");
        }
    }
}

// Subclass
class SavingsAccount extends BankAccount {

    SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);   // public
        System.out.println("Account Holder: " + accountHolder);   // protected
        // balance ❌ not accessible directly (private)

        System.out.println("Balance: ₹" + getBalance());          // via public method
    }
}

public class BankTest2 {
    public static void main(String[] args) {

        SavingsAccount sa = new SavingsAccount("ACC12345", "Ankit", 25000);

        sa.displayDetails();

        System.out.println("\nUpdating Balance...");
        sa.setBalance(30000);

        System.out.println("Updated Balance: ₹" + sa.getBalance());
    }
}
