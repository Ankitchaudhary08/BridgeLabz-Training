class Book {
    String title;
    String author;
    double price;
    boolean available;

    // Constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true; // book is available by default
    }

    // Method to borrow a book
    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("You have borrowed: " + title);
        } else {
            System.out.println("Sorry, the book is already borrowed.");
        }
    }

    // Method to display details
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println("Available: " + available);
    }
}

public class LibraryTest {
    public static void main(String[] args) {

        Book b1 = new Book("Java Basics", "James Gosling", 450);

        b1.display();
        System.out.println();

        b1.borrowBook();  // borrow the book
        b1.borrowBook();  // try again

        System.out.println();
        b1.display();
    }
}
