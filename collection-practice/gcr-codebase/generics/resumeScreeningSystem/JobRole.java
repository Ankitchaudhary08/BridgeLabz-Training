// Base class for all job roles
public abstract class JobRole {

    protected String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    // Each job role defines its own screening logic
    public abstract void screen();

    public String getCandidateName() {
        return candidateName;
    }
}
