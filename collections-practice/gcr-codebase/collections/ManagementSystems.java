import java.time.LocalDate;
import java.util.*;

public class ManagementSystems {

    /* 
       1. INSURANCE POLICY SYSTEM
       */

    static class Policy {
        String policyNumber;
        String holderName;
        LocalDate expiryDate;
        String coverageType;
        double premium;

        Policy(String policyNumber, String holderName,
               LocalDate expiryDate, String coverageType,
               double premium) {
            this.policyNumber = policyNumber;
            this.holderName = holderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premium = premium;
        }

        public String toString() {
            return policyNumber + " | " + holderName + " | " + expiryDate;
        }
    }

    static Map<String, Policy> policyMap = new HashMap<>();
    static Map<String, Policy> policyOrder = new LinkedHashMap<>();
    static TreeMap<LocalDate, Policy> policyByExpiry = new TreeMap<>();

    static void addPolicy(Policy p) {
        policyMap.put(p.policyNumber, p);
        policyOrder.put(p.policyNumber, p);
        policyByExpiry.put(p.expiryDate, p);
    }

    static void policiesExpiringSoon() {
        LocalDate limit = LocalDate.now().plusDays(30);
        for (var e : policyByExpiry.entrySet()) {
            if (!e.getKey().isAfter(limit)) {
                System.out.println(e.getValue());
            }
        }
    }

    /* 
       2. VOTING SYSTEM
       */

    static void votingSystem() {
        Map<String, Integer> votes = new HashMap<>();
        votes.put("Alice", 4);
        votes.put("Bob", 7);
        votes.put("Carol", 3);

        Map<String, Integer> voteOrder = new LinkedHashMap<>(votes);
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(votes);

        System.out.println("Votes: " + votes);
        System.out.println("Vote Order: " + voteOrder);
        System.out.println("Sorted Result: " + sortedVotes);
    }

    /* 
       3. SHOPPING CART SYSTEM
       */

    static void shoppingCart() {
        Map<String, Integer> prices = new HashMap<>();
        prices.put("Laptop", 60000);
        prices.put("Mouse", 800);
        prices.put("Keyboard", 1500);

        Map<String, Integer> cart = new LinkedHashMap<>();
        cart.put("Mouse", prices.get("Mouse"));
        cart.put("Laptop", prices.get("Laptop"));

        TreeMap<Integer, String> sortedByPrice = new TreeMap<>();
        for (var item : prices.entrySet()) {
            sortedByPrice.put(item.getValue(), item.getKey());
        }

        System.out.println("Cart: " + cart);
        System.out.println("Sorted by Price: " + sortedByPrice);
    }

    /* 
       4. BANKING SYSTEM
       */

    static void bankingSystem() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("A101", 5000);
        accounts.put("A102", 12000);
        accounts.put("A103", 3000);

        TreeMap<Integer, String> sortedByBalance = new TreeMap<>();
        for (var acc : accounts.entrySet()) {
            sortedByBalance.put(acc.getValue(), acc.getKey());
        }

        Queue<String> withdrawalQueue = new LinkedList<>();
        withdrawalQueue.add("A101");
        withdrawalQueue.add("A103");

        System.out.println("Accounts: " + accounts);
        System.out.println("Sorted by Balance: " + sortedByBalance);

        while (!withdrawalQueue.isEmpty()) {
            System.out.println("Processing withdrawal: " + withdrawalQueue.poll());
        }
    }

    /* 
       MAIN METHOD
        */

    public static void main(String[] args) {

        // Insurance policies
        addPolicy(new Policy("P101", "Alice",
                LocalDate.now().plusDays(10), "Health", 5000));
        addPolicy(new Policy("P102", "Bob",
                LocalDate.now().plusDays(40), "Auto", 7000));

        System.out.println("\nPolicies expiring soon:");
        policiesExpiringSoon();

        System.out.println("\nVoting System:");
        votingSystem();

        System.out.println("\nShopping Cart:");
        shoppingCart();

        System.out.println("\nBanking System:");
        bankingSystem();
    }
}
