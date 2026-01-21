// Base class for all warehouse items
public abstract class WarehouseItem {

    private final String name; // item name should not change

    // Constructor to initialize item name
    public WarehouseItem(String name) {
        this.name = name;
    }

    // Getter for item name
    public String getName() {
        return name;
    }

    // Each item must define how it is displayed
    public abstract void displayInfo();
}
