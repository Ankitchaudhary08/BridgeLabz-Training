// Screening for Product Manager role
public class ProductManager extends JobRole {

    public ProductManager(String name) {
        super(name);
    }

    @Override
    public void screen() {
        System.out.println(candidateName + " screened for Product + Business skills.");
    }
}
