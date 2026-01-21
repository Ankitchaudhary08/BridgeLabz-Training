// Screening for Software Engineer role
public class SoftwareEngineer extends JobRole {

    public SoftwareEngineer(String name) {
        super(name);
    }

    @Override
    public void screen() {
        System.out.println(candidateName + " screened for Coding + DSA skills.");
    }
}
