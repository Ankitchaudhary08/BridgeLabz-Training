import java.util.*;

public class ShoppingCart {

    public static void main(String[] args) {

        // 1. Product prices
        Map<String, Integer> priceMap = new HashMap<>();
        priceMap.put("Laptop", 60000);
        priceMap.put("Mouse", 800);
        priceMap.put("Keyboard", 1500);
        priceMap.put("Monitor", 12000);

        // 2. Cart (maintains insertion order)
        Map<String, Integer> cart = new LinkedHashMap<>();
        cart.put("Mouse", priceMap.get("Mouse"));
        cart.put("Laptop", priceMap.get("Laptop"));
        cart.put("Keyboard", priceMap.get("Keyboard"));

        // 3. Sort items by price
        TreeMap<Integer, List<String>> sortedByPrice = new TreeMap<>();

        for (Map.Entry<String, Integer> item : cart.entrySet()) {
            sortedByPrice
                .computeIfAbsent(item.getValue(), k -> new ArrayList<>())
                .add(item.getKey());
        }

        System.out.println("Product Prices (HashMap): " + priceMap);
        System.out.println("Cart Order (LinkedHashMap): " + cart);
        System.out.println("Items Sorted by Price (TreeMap): " + sortedByPrice);
    }
}
