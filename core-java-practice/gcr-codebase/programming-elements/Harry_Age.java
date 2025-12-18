import java.util.Scanner;

public class Harry_Age {
    public static void main(String[] args) {

         Scanner sc = new Scanner(System.in); 

        // Harry birth year 7
        System.out.print("Enter your birth year: ");
        int birthYear = sc.nextInt();
        int currYear = 2024; // Current year

        // harry age
        int age = currYear - birthYear;

        // harray age in 2024
        System.out.println("Harry's age in 2024 is " + age);
    }
}
