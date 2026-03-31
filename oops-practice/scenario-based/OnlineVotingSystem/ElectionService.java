package OnlineVotingSystem;

public interface ElectionService {

    void registerVoter(Voter voter);
    void addCandidate(Candidate candidate);

    void castVote(Vote vote) throws DuplicateVoteException;

    void declareResults();
}

