import java.util.*;

public class CorporateEmailAccessControl {

    static boolean isValidEmail(String email) {
        // empFirstname.empLastname+digits@department.company.com
        // firstname and lastname: only lowercase, min 3 chars
        // digits: at least 4
        // department: sales, marketing, IT, product
        // domain: company.com
        String regex = "^([a-z]{3,})\\.([a-z]{3,})\\+(\\d{4,})@(sales|marketing|IT|product)\\.company\\.com$";
        return email.matches(regex);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String email = sc.nextLine().trim();
            System.out.println(isValidEmail(email) ? "Access Granted" : "Access Denied");
        }
        sc.close();
    }
}
