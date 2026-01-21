import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {

        // Create resumes
        Resume<SoftwareEngineer> seResume =
                new Resume<>(new SoftwareEngineer("Alice"));

        Resume<DataScientist> dsResume =
                new Resume<>(new DataScientist("Bob"));

        Resume<ProductManager> pmResume =
                new Resume<>(new ProductManager("Charlie"));

        // Screen individual resumes
        ScreeningPipeline.screenResume(seResume);
        ScreeningPipeline.screenResume(dsResume);
        ScreeningPipeline.screenResume(pmResume);

        // Add multiple roles to screening pipeline
        List<JobRole> roleList = new ArrayList<>();
        roleList.add(new SoftwareEngineer("David"));
        roleList.add(new DataScientist("Eva"));
        roleList.add(new ProductManager("Frank"));

        // Run AI screening on all roles
        ScreeningPipeline.runScreening(roleList);
    }
}
