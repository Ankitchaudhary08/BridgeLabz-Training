package InventoryManagementSystem;
public class Main {

    public static void main(String[] args) {

        AlertService alertService = new EmailAlertService();
        Inventory inventory = new Inventory(alertService);

        Product p1 = new Product(101, "Keyboard", 10);
        inventory.addProduct(p1);

        try {
            inventory.updateStock(101, 3);   // Low stock alert
            inventory.updateStock(101, 0);   // OutOfStockException
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
    }
}
