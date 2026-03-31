import java.util.*;

public class MultiTypeBankAccountManagement {

    abstract static class Account {
        String accountNumber, holderName, accountType;
        double balance;

        Account(String accountNumber, String holderName, double balance) {
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = balance;
        }

        void deposit(double amount) {
            balance += amount;
        }

        abstract boolean withdraw(double amount);
    }

    static class SavingsAccount extends Account {
        SavingsAccount(String accountNumber, String holderName, double balance) {
            super(accountNumber, holderName, balance);
        }

        @Override
        boolean withdraw(double amount) {
            double charge = 2;
            double total = amount + charge;
            if (balance - total < 0) return false;
            balance -= total;
            return true;
        }
    }

    static class CurrentAccount extends Account {
        CurrentAccount(String accountNumber, String holderName, double balance) {
            super(accountNumber, holderName, balance);
        }

        @Override
        boolean withdraw(double amount) {
            double charge = 5;
            double total = amount + charge;
            if (balance - total < -10000) return false;
            balance -= total;
            return true;
        }
    }

    static class BusinessAccount extends Account {
        BusinessAccount(String accountNumber, String holderName, double balance) {
            super(accountNumber, holderName, balance);
        }

        @Override
        boolean withdraw(double amount) {
            double charge = amount * 0.01;
            double total = amount + charge;
            if (balance - total < -50000) return false;
            balance -= total;
            return true;
        }
    }

    static List<Account> accounts = new ArrayList<>();

    static Account findAccount(String accountNumber) {
        for (Account a : accounts) if (a.accountNumber.equals(accountNumber)) return a;
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");
            String cmd = parts[0];

            if (cmd.equals("Create")) {
                String accNum = parts[1];
                String holderName = parts[2];
                String type = parts[3];
                double initialBalance = Double.parseDouble(parts[4]);

                Account acc;
                if (type.equals("SavingsAccount")) {
                    acc = new SavingsAccount(accNum, holderName, initialBalance);
                } else if (type.equals("CurrentAccount")) {
                    acc = new CurrentAccount(accNum, holderName, initialBalance);
                } else {
                    acc = new BusinessAccount(accNum, holderName, initialBalance);
                }
                accounts.add(acc);
                System.out.println("Account Created: " + accNum);

            } else if (cmd.equals("Deposit")) {
                String accNum = parts[1];
                double amount = Double.parseDouble(parts[2]);
                Account acc = findAccount(accNum);
                if (acc == null) {
                    System.out.println("Account Not Found");
                } else {
                    acc.deposit(amount);
                    System.out.println("Deposited Successfully");
                }

            } else if (cmd.equals("Withdraw")) {
                String accNum = parts[1];
                double amount = Double.parseDouble(parts[2]);
                Account acc = findAccount(accNum);
                if (acc == null) {
                    System.out.println("Account Not Found");
                } else {
                    boolean success = acc.withdraw(amount);
                    System.out.println(success ? "Withdrawal Successful" : "Insufficient Funds");
                }
            }
        }
        sc.close();
    }
}
