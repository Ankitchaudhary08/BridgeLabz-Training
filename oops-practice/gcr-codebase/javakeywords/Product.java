class Product {

    // Static variable
    static double discount = 10.0;   // discount in percentage

    // Instance variables
    final String productID;   // final variable
    String productName;
    double price;
    int quantity;

    // Constructor using this
    Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Static method
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    // Method using instanceof
    void displayProductDetails(Object obj) {
        if (obj instanceof Product) {
            Product p = (Product) obj;

            System.out.println("Product ID: " + p.productID);
            System.out.println("Product Name: " + p.productName);
            System.out.println("Price: $" + p.price);
            System.out.println("Quantity: " + p.quantity);
            System.out.println("Discount: " + discount + "%");

            double discountedPrice = p.price - (p.price * discount / 100);
            System.out.println("Price after Discount: $" + discountedPrice);
        }
    }

    // Main method
    public static void main(String[] args) {

        Product product = new Product(
                "P001",
                "Laptop",
                1200.0,
                5
        );

        product.displayProductDetails(product);
    }
}
