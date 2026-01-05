// Discount interface
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Abstract FoodItem class
abstract class FoodItem {

    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation: getters
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + calculateTotalPrice());
    }
}

// VegItem class
class VegItem extends FoodItem implements Discountable {

    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount: 10%";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {

    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        double extraCharge = 50;
        return (getPrice() * getQuantity()) + extraCharge;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: 5%";
    }
}

// Main class
public class OnlineFoodDeliverySystem {

    // Polymorphic order processing
    public static void processOrder(FoodItem item) {

        double total = item.calculateTotalPrice();
        double discount = 0;

        if (item instanceof Discountable) {
            discount = ((Discountable) item).applyDiscount();
        }

        double finalAmount = total - discount;

        item.getItemDetails();
        System.out.println("Discount: " + discount);
        System.out.println("Final Amount: " + finalAmount);
        System.out.println("----------------------");
    }

    public static void main(String[] args) {

        FoodItem item1 = new VegItem("Paneer Butter Masala Fry", 250, 2);
        FoodItem item2 = new NonVegItem("Chicken Biryani", 350, 1);

        processOrder(item1);
        processOrder(item2);
    }
}
