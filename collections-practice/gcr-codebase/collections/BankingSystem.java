import java.util.*;

public class BankingSystem {

    public static void main(String[] args) {

        // 1. Store customer accounts
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("A101", 5000);
        accounts.put("A102", 12000);
        accounts.put("A103", 3000);
        accounts.put("A104", 8000);

        // 2. Sort customers by balance
        TreeMap<Integer, List<String>> sortedByBalance = new TreeMap<>();
        for (Map.Entry<String, Integer> acc : accounts.entrySet()) {
            sortedByBalance
                .computeIfAbsent(acc.getValue(), k -> new ArrayList<>())
                .add(acc.getKey());
        }

        // 3. Withdrawal requests queue
        Queue<String> withdrawalQueue = new LinkedList<>();
        withdrawalQueue.add("A101");
        withdrawalQueue.add("A103");

        System.out.println("Accounts (HashMap): " + accounts);
        System.out.println("Customers Sorted by Balance (TreeMap): " + sortedByBalance);

        // Process withdrawals
        while (!withdrawalQueue.isEmpty()) {
            String accNo = withdrawalQueue.poll();
            int balance = accounts.get(accNo);

            System.out.println("Processing withdrawal for " + accNo +
                               " | Balance: " + balance);
        }
    }
}
