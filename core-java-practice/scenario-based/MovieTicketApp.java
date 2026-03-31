import java.util.Scanner;

public class MovieTicketApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            int price = 0;

            System.out.print("Enter movie type (2D/3D): ");
            String movieType = sc.next();

            System.out.print("Enter seat type (gold/silver): ");
            String seatType = sc.next();

            System.out.print("Want snacks? (yes/no): ");
            String snacks = sc.next();

            // seat price using switch
            switch (seatType.toLowerCase()) {
                case "gold":
                    price = 300;
                    break;
                case "silver":
                    price = 200;
                    break;
                default:
                    System.out.println("Invalid seat type");
            }

            // movie type charge
            if (movieType.equalsIgnoreCase("3D")) {
                price += 100;
            }

            // snacks charge
            if (snacks.equalsIgnoreCase("yes")) {
                price += 80;
            }

            System.out.println("Total Ticket Price: ₹" + price);

            System.out.print("Next customer? (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        sc.close();
    }
}
