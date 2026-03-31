class Item {

    String itemCode;
    String itemName;
    double itemPrice;

    // this method display item details
    void displayItemDetails() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + itemPrice);
        System.out.println("itemName : " + itemName);
        System.out.println("----------------------------");
    }

    // this method calculate total cost
    double calculateTotalCost(int quantity) {
        return itemPrice * quantity;
    }

    public static void main(String[] args) {

        // first item
        Item item1 = new Item();
        item1.itemCode = "01AA";
        item1.itemPrice = 500.0;
        item1.itemName = "Water bottle";

        // second item
        Item item2 = new Item();
        item2.itemCode = "01BB";
        item2.itemPrice = 700.0;
        item2.itemName = "Rice";

        // third item
        Item item3 = new Item();
        item3.itemCode = "02AA";
        item3.itemPrice = 400.0;
        item3.itemName = "blackboard";

        // display item details
        item1.displayItemDetails();
        item2.displayItemDetails();
        item3.displayItemDetails();
    }
}
