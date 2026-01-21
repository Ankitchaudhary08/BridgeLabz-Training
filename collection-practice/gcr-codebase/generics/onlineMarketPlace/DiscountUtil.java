// Utility class for discount operations
public class DiscountUtil {

    // Generic method with bounded type parameter
    public static <T extends Product<?>> void applyDiscount(
            T product, double percentage) {

        double discount = product.getPrice() * (percentage / 100);
        double newPrice = product.getPrice() - discount;

        product.setPrice(newPrice);
    }
}
