// Node class
class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

// Inventory Management using Singly Linked List
class InventoryManager {

    private ItemNode head;

    // Add at beginning
    public void addAtBeginning(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addAtEnd(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);

        if (head == null) {
            head = newNode;
            return;
        }

        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add at specific position (1-based)
    public void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos == 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        ItemNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove by Item ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory empty");
            return;
        }

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed");
            return;
        }

        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed");
        }
    }

    // Update quantity by ID
    public void updateQuantity(int id, int newQty) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // Search by ID
    public void searchById(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // Search by Name
    public void searchByName(String name) {
        ItemNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Item not found");
        }
    }

    // Calculate total inventory value
    public void totalInventoryValue() {
        double total = 0;
        ItemNode temp = head;

        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value = " + total);
    }

    // Sort by Name (Ascending / Descending)
    public void sortByName(boolean ascending) {
        head = mergeSort(head, ascending, true);
    }

    // Sort by Price (Ascending / Descending)
    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, ascending, false);
    }

    // Merge Sort for Linked List
    private ItemNode mergeSort(ItemNode h, boolean asc, boolean byName) {
        if (h == null || h.next == null)
            return h;

        ItemNode mid = getMiddle(h);
        ItemNode nextMid = mid.next;
        mid.next = null;

        ItemNode left = mergeSort(h, asc, byName);
        ItemNode right = mergeSort(nextMid, asc, byName);

        return merge(left, right, asc, byName);
    }

    private ItemNode merge(ItemNode a, ItemNode b, boolean asc, boolean byName) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (byName) {
            condition = asc
                ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }

        if (condition) {
            a.next = merge(a.next, b, asc, byName);
            return a;
        } else {
            b.next = merge(a, b.next, asc, byName);
            return b;
        }
    }

    private ItemNode getMiddle(ItemNode h) {
        ItemNode slow = h;
        ItemNode fast = h.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display all items
    public void displayAll() {
        ItemNode temp = head;
        if (temp == null) {
            System.out.println("No items");
            return;
        }

        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    private void displayItem(ItemNode i) {
        System.out.println(
            i.itemId + " | " +
            i.itemName + " | Qty: " +
            i.quantity + " | Price: " +
            i.price
        );
    }
}

// Class name is NOT Main
public class InventoryApp {
    public static void main(String[] args) {

        InventoryManager inv = new InventoryManager();

        inv.addAtEnd(101, "Laptop", 5, 50000);
        inv.addAtEnd(102, "Mouse", 20, 500);
        inv.addAtBeginning(103, "Keyboard", 10, 1500);

        inv.displayAll();

        inv.updateQuantity(101, 8);
        inv.searchByName("Mouse");

        inv.totalInventoryValue();

        System.out.println("\nSorted by Price (Ascending):");
        inv.sortByPrice(true);
        inv.displayAll();

        System.out.println("\nSorted by Name (Descending):");
        inv.sortByName(false);
        inv.displayAll();
    }
}
