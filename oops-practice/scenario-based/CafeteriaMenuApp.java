import java.util.Scanner;

public class CafeteriaMenuApp {

    // Method to display menu
    public static void displayMenu(String[] items) {
        System.out.println("---- Cafeteria Menu ----");
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + ". " + items[i]);
        }
    }

    // Method to get item by index
    public static String getItemByIndex(String[] items, int index) {

        if (index >= 0 && index < items.length) {
            return items[index];
        } else {
            return "Invalid selection";
        }
    }

    public static void main(String[] args) {

        // 10 fixed items
        String[] menuItems = {
                "Tea",
                "Coffee",
                "Sandwich",
                "Burger",
                "Pizza",
                "Pasta",
                "Noodles",
                "Samosa",
                "Vada Pav",
                "Fruit Juice"
        };

        Scanner sc = new Scanner(System.in);

        // Display menu
        displayMenu(menuItems);

        // Take user input
        System.out.print("\nEnter item index to order: ");
        int choice = sc.nextInt();

        // Get selected item
        String selectedItem = getItemByIndex(menuItems, choice);

        System.out.println("You selected: " + selectedItem);

        sc.close();
    }
}
