// Screening for Data Scientist role
public class DataScientist extends JobRole {

    public DataScientist(String name) {
        super(name);
    }

    @Override
    public void screen() {
        System.out.println(candidateName + " screened for ML + Statistics skills.");
    }
}
