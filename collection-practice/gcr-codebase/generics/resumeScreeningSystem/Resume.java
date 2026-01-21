// Generic Resume class
// T must be a JobRole
public class Resume<T extends JobRole> {

    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    // Process resume based on job role
    public void processResume() {
        System.out.println("Processing resume...");
        jobRole.screen();
    }

    public T getJobRole() {
        return jobRole;
    }
}
