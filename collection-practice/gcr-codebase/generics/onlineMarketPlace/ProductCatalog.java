import java.util.ArrayList;
import java.util.List;

// Stores all products together
public class ProductCatalog {

    private List<Product<?>> products = new ArrayList<>();

    // Add any type of product
    public void addProduct(Product<?> product) {
        products.add(product);
    }

    // Display all products
    public void showCatalog() {
        for (Product<?> product : products) {
            product.display();
        }
    }
}
