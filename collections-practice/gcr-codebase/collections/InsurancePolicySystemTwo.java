import java.time.LocalDate;
import java.util.*;

public class InsurancePolicySystemTwo {

    //  Policy Model
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

        @Override
        public String toString() {
            return policyNumber + " | " + holderName +
                   " | " + coverageType + " | " + expiryDate;
        }
    }

    // Maps 
    static Map<String, Policy> hashMap = new HashMap<>();
    static Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    static TreeMap<LocalDate, Policy> treeMap = new TreeMap<>();

    //  Store Policy
    static void addPolicy(Policy p) {
        hashMap.put(p.policyNumber, p);
        linkedHashMap.put(p.policyNumber, p);
        treeMap.put(p.expiryDate, p);
    }

    //  Retrieve Policy by Number 
    static void getPolicyByNumber(String policyNumber) {
        System.out.println(hashMap.get(policyNumber));
    }

    //  Policies Expiring in Next 30 Days 
    static void policiesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        for (Map.Entry<LocalDate, Policy> entry : treeMap.entrySet()) {
            if (!entry.getKey().isAfter(next30Days)) {
                System.out.println(entry.getValue());
            }
        }
    }

    //  Policies by Policyholder 
    static void policiesByHolder(String holderName) {
        for (Policy p : hashMap.values()) {
            if (p.holderName.equalsIgnoreCase(holderName)) {
                System.out.println(p);
            }
        }
    }

    // ================= Remove Expired Policies =================
    static void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        hashMap.values().removeIf(p -> p.expiryDate.isBefore(today));
        linkedHashMap.values().removeIf(p -> p.expiryDate.isBefore(today));
        treeMap.headMap(today).clear();
    }

    // ================= Main =================
    public static void main(String[] args) {

        addPolicy(new Policy("P101", "Alice",
                LocalDate.now().plusDays(10), "Health", 5000));

        addPolicy(new Policy("P102", "Bob",
                LocalDate.now().plusDays(40), "Auto", 7000));

        addPolicy(new Policy("P103", "Alice",
                LocalDate.now().plusDays(25), "Home", 6000));

        System.out.println("Get Policy P101:");
        getPolicyByNumber("P101");

        System.out.println("\nPolicies Expiring in 30 Days:");
        policiesExpiringSoon();

        System.out.println("\nPolicies for Alice:");
        policiesByHolder("Alice");

        System.out.println("\nRemoving expired policies...");
        removeExpiredPolicies();
    }
}
