import java.util.Scanner;

public class LibraryFineCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {

            System.out.println("Book " + i);

            System.out.print("Enter due day: ");
            int dueDay = sc.nextInt();

            System.out.print("Enter return day: ");
            int returnDay = sc.nextInt();

            if (returnDay > dueDay) {
                int lateDays = returnDay - dueDay;
                int fine = lateDays * 5;
                System.out.println("Late fine: ₹" + fine);
            } else {
                System.out.println("No fine, returned on time");
            }

            System.out.println("---------------------");
        }

        sc.close();
    }
}
