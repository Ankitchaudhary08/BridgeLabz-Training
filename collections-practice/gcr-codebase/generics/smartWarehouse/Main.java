public class Main {

    public static void main(String[] args) {

        // Electronics storage
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Mobile"));

        // Grocery storage
        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Milk"));

        // Furniture storage
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));

        // Display all items using wildcard method
        WarehouseUtil.displayAll(electronicsStorage.getItems());
        WarehouseUtil.displayAll(groceryStorage.getItems());
        WarehouseUtil.displayAll(furnitureStorage.getItems());
    }
}
