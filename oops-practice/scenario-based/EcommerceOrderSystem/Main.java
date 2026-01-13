public class Main {
    public static void main(String[] args) {

        Product product = new Product(1, "Laptop", 50000);
        Order order = new Order(product, 1);

        Payment payment = new UPIPayment(); // Polymorphism

        order.placeOrder(payment);
    }
}
