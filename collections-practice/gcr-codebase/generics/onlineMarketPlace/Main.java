public class Main {

    public static void main(String[] args) {

        // Create products
        Product<Book> book =
                new Product<>("Java Basics", 500, new Book());

        Product<Clothing> shirt =
                new Product<>("T-Shirt", 1200, new Clothing());

        Product<Gadget> phone =
                new Product<>("Smartphone", 20000, new Gadget());

        // Create catalog
        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        System.out.println("Before Discount:");
        catalog.showCatalog();

        // Apply discounts
        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 20);
        DiscountUtil.applyDiscount(phone, 5);

        System.out.println("\nAfter Discount:");
        catalog.showCatalog();
    }
}
