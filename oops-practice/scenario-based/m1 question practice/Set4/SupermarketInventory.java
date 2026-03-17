import java.util.*;

public class SupermarketInventory {

    abstract static class Product {
        String name;
        double price;
        int quantity;

        Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        abstract void display();

        double totalValue() {
            return price * quantity;
        }
    }

    static class Electronics extends Product {
        int warranty;

        Electronics(String name, double price, int quantity, int warranty) {
            super(name, price, quantity);
            this.warranty = warranty;
        }

        @Override
        void display() {
            System.out.printf("%s - Price: %.1f, Quantity: %d, Warranty: %d months%n",
                    name, price, quantity, warranty);
        }
    }

    static class Clothing extends Product {
        String size;

        Clothing(String name, double price, int quantity, String size) {
            super(name, price, quantity);
            this.size = size;
        }

        @Override
        void display() {
            System.out.printf("%s - Price: %.2f, Quantity: %d, Size: %s%n",
                    name, price, quantity, size);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine().trim());
        List<Product> inventory = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(", ");
            String type = parts[0];
            String name = parts[1];
            double price = Double.parseDouble(parts[2]);
            int qty = Integer.parseInt(parts[3]);

            if (type.equals("Electronics")) {
                int warranty = Integer.parseInt(parts[4]);
                inventory.add(new Electronics(name, price, qty, warranty));
            } else if (type.equals("Clothing")) {
                String size = parts[4];
                inventory.add(new Clothing(name, price, qty, size));
            }
            System.out.println("Product added to inventory: " + name);
        }

        System.out.println();
        System.out.println("Inventory:");
        for (Product p : inventory) {
            p.display();
        }

        double total = 0;
        for (Product p : inventory) total += p.totalValue();
        System.out.printf("%nTotal value of the inventory: %.2f%n", total);

        sc.close();
    }
}
