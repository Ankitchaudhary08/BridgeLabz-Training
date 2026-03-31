package DigitalWalletSystem;
public class Wallet {
    private String walletId;
    private double balance;

    public Wallet(String walletId) {
        this.walletId = walletId;
        this.balance = 0;
    }

    public void addMoney(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " added. Balance: ₹" + balance);
    }

    public void withdrawMoney(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
        System.out.println("₹" + amount + " withdrawn. Balance: ₹" + balance);
    }

    public double getBalance() {
        return balance;
    }
}
