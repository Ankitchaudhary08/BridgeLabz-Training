import java.util.*;
public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the salary: ");
        
        double salary = scanner.nextDouble();

        System.out.print("Enter years of service: ");
        int yearsOfService = scanner.nextInt();

        if (yearsOfService > 5) {
            double bonus = salary * 0.05;
            System.out.println("The bonus amount is " + bonus);
        } else {
            System.out.println("The bonus amount is 0.0");
        }
       
    }
}