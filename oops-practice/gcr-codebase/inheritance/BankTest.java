// Superclass
class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayAccountType() {
        System.out.println("Generic Bank Account");
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}

// CheckingAccount subclass
class CheckingAccount extends BankAccount {
    int withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, int withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }
}

// FixedDepositAccount subclass
class FixedDepositAccount extends BankAccount {
    int tenureYears;

    FixedDepositAccount(String accountNumber, double balance, int tenureYears) {
        super(accountNumber, balance);
        this.tenureYears = tenureYears;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }
}

// Main class
public class BankTest {
    public static void main(String[] args) {

        BankAccount a1 = new SavingsAccount("SA101", 50000, 4.5);
        BankAccount a2 = new CheckingAccount("CA102", 30000, 5);
        BankAccount a3 = new FixedDepositAccount("FD103", 100000, 3);

        a1.displayAccountType();
        a1.displayDetails();
        System.out.println();

        a2.displayAccountType();
        a2.displayDetails();
        System.out.println();

        a3.displayAccountType();
        a3.displayDetails();
    }
}
