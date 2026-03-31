public class BankTransactionSystem {

    static double balance = 5000;

    // Method to withdraw money
    public static void withdraw(double amount) throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        balance = balance - amount;
        System.out.println("Withdrawal successful");
        System.out.println("Remaining balance: " + balance);
    }

    public static void main(String[] args) {

        try {
            withdraw(7000); // change amount to test
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    // Custom Checked Exception (INNER CLASS)
    static class InsufficientBalanceException extends Exception {

        public InsufficientBalanceException(String message) {
            super(message);
        }
    }
}
