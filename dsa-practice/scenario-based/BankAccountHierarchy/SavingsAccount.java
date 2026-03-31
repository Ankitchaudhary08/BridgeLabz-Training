// Savings account class extends BankAccount
class SavingsAccount extends BankAccount {

    // Constructor passes values to parent class
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    // Savings account fee is 0.5% of balance
    @Override
    public double calculateFee() {
        return getBalance() * 0.005; // simple calculation, no extra objects
    }
}
