class Product {
    // Instance variables (different for each object)
    String productName;
    double price;

    // Class variable (shared by all objects)
    static int totalProducts = 0;

    // Constructor
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // count every product created
    }

    // Instance method
    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }

    // Class (static) method
    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }
}

public class ProductTest {
    public static void main(String[] args) {

        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Mobile", 25000);

        p1.displayProductDetails();
        System.out.println();

        p2.displayProductDetails();
        System.out.println();

        Product.displayTotalProducts(); // class method call
    }
}
