import java.util.*;

public class VotingSystem {

    public static void main(String[] args) {

        // 1. Store votes (Candidate -> Votes)
        Map<String, Integer> voteMap = new HashMap<>();
        voteMap.put("Alice", 5);
        voteMap.put("Bob", 8);
        voteMap.put("Carol", 3);

        // 2. Maintain insertion order
        Map<String, Integer> voteOrder = new LinkedHashMap<>();
        voteOrder.putAll(voteMap);

        // 3. Display sorted results
        Map<String, Integer> sortedVotes = new TreeMap<>(voteMap);

        System.out.println("Votes (HashMap): " + voteMap);
        System.out.println("Vote Order (LinkedHashMap): " + voteOrder);
        System.out.println("Sorted Result (TreeMap): " + sortedVotes);
    }
}
