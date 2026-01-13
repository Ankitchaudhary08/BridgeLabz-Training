package OnlineVotingSystem;

public class Main {

    public static void main(String[] args) {

        ElectionService electionService = new ElectionServiceImpl();

        Voter v1 = new Voter(1, "Ankit");
        Voter v2 = new Voter(2, "Rahul");

        Candidate c1 = new Candidate(101, "Alice");
        Candidate c2 = new Candidate(102, "Bob");

        electionService.registerVoter(v1);
        electionService.registerVoter(v2);

        electionService.addCandidate(c1);
        electionService.addCandidate(c2);

        try {
            electionService.castVote(new Vote(v1, c1));
            electionService.castVote(new Vote(v2, c2));
            electionService.castVote(new Vote(v1, c2)); // Exception
        } catch (DuplicateVoteException e) {
            System.out.println(e.getMessage());
        }

        electionService.declareResults();
    }
}
