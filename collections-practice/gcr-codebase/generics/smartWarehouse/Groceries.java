// Grocery item
public class Groceries extends WarehouseItem {

    public Groceries(String name) {
        super(name);
    }

    @Override
    public void displayInfo() {
        System.out.println("Grocery Item: " + getName());
    }
}
