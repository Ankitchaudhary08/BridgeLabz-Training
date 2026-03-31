// Reservable interface
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Abstract LibraryItem class
abstract class LibraryItem {

    private int itemId;
    private String title;
    private String author;
    private String borrowerName;
    private boolean available = true;

    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Encapsulation: borrower data
    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
        this.available = false;
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }

    // Availability methods
    public boolean isAvailable() {
        return available;
    }
}

// Book class
class Book extends LibraryItem implements Reservable {

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public void reserveItem() {
        System.out.println("Book reserved");
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem() {
        System.out.println("Magazine reserved");
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }

    @Override
    public void reserveItem() {
        System.out.println("DVD reserved");
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Main class
public class LibraryManagementSystem {

    public static void main(String[] args) {

        LibraryItem item1 = new Book(101, "Java Basics", "James Gosling");
        LibraryItem item2 = new Magazine(102, "Tech Today", "Editor Team");
        LibraryItem item3 = new DVD(103, "Inception", "Christopher Nolan");

        LibraryItem[] items = { item1, item2, item3 };

        for (LibraryItem item : items) {
            item.getItemDetails();

            Reservable r = (Reservable) item;
            System.out.println("Available: " + r.checkAvailability());
            r.reserveItem();

            System.out.println("----------------------");
        }
    }
}
