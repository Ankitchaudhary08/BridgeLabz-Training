import java.util.List;

// Utility class for warehouse operations
public class WarehouseUtil {

    // Wildcard method to display all items
    public static void displayAll(List<? extends WarehouseItem> items) {

        for (WarehouseItem item : items) {
            item.displayInfo();
        }
    }
}
