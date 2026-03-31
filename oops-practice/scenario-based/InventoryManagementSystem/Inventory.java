package InventoryManagementSystem;

import java.util.HashMap;

public class Inventory {

    private HashMap<Integer, Product> products;
    private AlertService alertService;

    public Inventory(AlertService alertService) {
        this.products = new HashMap<>();
        this.alertService = alertService;
    }

    // Add product to inventory
    public void addProduct(Product product) {
        products.put(product.getId(), product);
        System.out.println("Product added: " + product.getName());
    }

    // Update product stock
    public void updateStock(int productId, int newQuantity)
            throws OutOfStockException {

        Product product = products.get(productId);

        if (product == null) {
            System.out.println("Product not found");
            return;
        }

        // CORRECT METHOD NAME
        product.setQuantity(newQuantity);

        if (newQuantity == 0) {
            throw new OutOfStockException(
                    product.getName() + " is OUT OF STOCK"
            );
        }

        if (newQuantity < 5) {
            alertService.sendLowStockAlert(product);
        }
    }
}
