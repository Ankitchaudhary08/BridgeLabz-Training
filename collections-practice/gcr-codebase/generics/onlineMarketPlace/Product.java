// Generic Product class
public class Product<T> {

    private String name;
    private double price;
    private T category; // Category type is generic

    // Constructor
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    // Update price after discount
    public void setPrice(double price) {
        this.price = price;
    }

    // Display product details
    public void display() {
        System.out.println(name + " | Price: " + price);
    }
}
