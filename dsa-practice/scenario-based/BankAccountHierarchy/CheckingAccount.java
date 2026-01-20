// Checking account class extends BankAccount
class CheckingAccount extends BankAccount {

    // Constructor for checking account
    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    // If balance is less than 1000, apply flat fee of 1.0
    // Otherwise, no fee
    @Override
    public double calculateFee() {
        return getBalance() < 1000 ? 1.0 : 0.0;
    }
}
