public class Order {
    private Product product;
    private int quantity;
    private String status;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.status = "CREATED";
    }

    public double getTotalAmount() {
        return product.getPrice() * quantity;
    }

    public void placeOrder(Payment payment) {
        try {
            payment.pay(getTotalAmount());
            status = "PLACED";
            System.out.println("Order placed successfully for " + product.getName());
        } catch (PaymentFailedException e) {
            status = "FAILED";
            System.out.println(e.getMessage());
        }
    }

    public void cancelOrder() {
        status = "CANCELLED";
        System.out.println("Order cancelled");
    }
}
