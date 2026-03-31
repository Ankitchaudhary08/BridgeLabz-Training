// This is the base class for all bank accounts
abstract class BankAccount {

    // Account number should not change, so it is final
    private final String accountNumber;

    // Balance is kept final to maintain immutability and safety
    private final double balance;

    // Constructor to initialize account details
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter to read account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter to read balance
    public double getBalance() {
        return balance;
    }

    // Each account type will calculate fee in its own way
    public abstract double calculateFee();
}
