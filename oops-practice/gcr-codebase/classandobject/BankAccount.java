class BankAccount {

    String accountHolder;
    String accountNumber;
    double balance;

    // this method deposit money in account
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Current balance: " + balance);
    }

    // this method withdraw money if balance is enough
    void withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Withdraw amount is : " + amount);
            System.out.println("Current balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // this method show current balance
    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    public static void main(String[] args) {

        System.out.println("State of Chennai\n");

        // create bank account object
        BankAccount acc = new BankAccount();
        acc.accountHolder = "Ramesh";
        acc.accountNumber = "ACC123";
        acc.balance = 700.0;

        // show initial balance
        acc.displayBalance();

        // deposit money
        acc.deposit(200.0);

        // withdraw money
        acc.withdraw(100.0);

        // try to withdraw more than balance
        acc.withdraw(1000.0);
    }
}
