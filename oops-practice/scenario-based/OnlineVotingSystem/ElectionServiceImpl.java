package OnlineVotingSystem;

import java.util.ArrayList;
import java.util.List;

public class ElectionServiceImpl implements ElectionService {

    private List<Voter> voters = new ArrayList<>();
    private List<Candidate> candidates = new ArrayList<>();

    @Override
    public void registerVoter(Voter voter) {
        voters.add(voter);
        System.out.println("Voter registered: " + voter.getName());
    }

    @Override
    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
        System.out.println("Candidate added: " + candidate.getName());
    }

    @Override
    public void castVote(Vote vote) throws DuplicateVoteException {

        Voter voter = vote.getVoter();

        if (voter.hasVoted()) {
            throw new DuplicateVoteException(
                    "Duplicate vote not allowed for " + voter.getName()
            );
        }

        vote.getCandidate().addVote();
        voter.markVoted();

        System.out.println(
                voter.getName() + " voted for " +
                vote.getCandidate().getName()
        );
    }

    @Override
    public void declareResults() {
        System.out.println("\n--- Election Results ---");
        for (Candidate candidate : candidates) {
            System.out.println(
                    candidate.getName() +
                    " : " +
                    candidate.getVoteCount() + " votes"
            );
        }
    }
}
