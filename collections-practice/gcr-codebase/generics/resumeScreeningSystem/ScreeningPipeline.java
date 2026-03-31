import java.util.List;

// Handles screening for multiple job roles
public class ScreeningPipeline {

    // Wildcard method to process any job role
    public static void runScreening(List<? extends JobRole> roles) {

        System.out.println("AI Screening Pipeline Started...");

        for (JobRole role : roles) {
            role.screen();
        }
    }

    // Generic method for single resume screening
    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        resume.processResume();
    }
}
