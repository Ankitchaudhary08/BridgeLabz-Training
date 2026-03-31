
import java.util.ArrayList;
import java.util.List;

// Generic storage class
// T must be WarehouseItem or its subclass
public class Storage<T extends WarehouseItem> {

    private List<T> items = new ArrayList<>();

    // Add item to storage
    public void addItem(T item) {
        items.add(item);
    }

    // Get all stored items
    public List<T> getItems() {
        return items;
    }
}
