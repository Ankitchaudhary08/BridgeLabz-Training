class CartItem {

    String itemName;
    double price;
    int quantity;

    // this method show item details
    void displayItem() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }

    // this method add quantity to cart
    void addItem(int qty) {
        quantity = quantity + qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    // this method remove quantity from cart
    void removeItem(int qty) {
        if (quantity >= qty) {
            quantity = quantity - qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove item, not enough quantity");
        }
    }

    // this method calculate total cost
    double getTotalCost() {
        return price * quantity;
    }

    public static void main(String[] args) {

        CartItem item = new CartItem();

        // assign item details
        item.itemName = "Laptop";
        item.price = 999.99;
        item.quantity = 1;

        // display initial item
        item.displayItem();

        // add items
        item.addItem(2);

        // remove item
        item.removeItem(1);

        // display total cost
        System.out.println("Total cost: $" + item.getTotalCost());
    }
}
