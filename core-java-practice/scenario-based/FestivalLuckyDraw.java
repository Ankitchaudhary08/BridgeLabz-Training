import java.util.Scanner;

public class FestivalLuckyDraw {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char more = 'y';

        // loop for multiple visitors
        while (more == 'y' || more == 'Y') {

            System.out.print("Enter your lucky number: ");
            int num = sc.nextInt();

            // invalid input check
            if (num <= 0) {
                System.out.println("Invalid number, try again");
                continue; // skip this visitor
            }

            // check gift condition
            if (num % 3 == 0 && num % 5 == 0) {
                System.out.println("🎉 Congratulations! You won a gift!");
            } else {
                System.out.println("Sorry, better luck next time");
            }

            System.out.print("Next visitor? (y/n): ");
            more = sc.next().charAt(0);
        }

        // lucky draw finish
        sc.close();
    }
}
