
class Book1 {
    String title;
    String author;
    double price;

    // Default constructor
    Book1() {
        title = "Not Assigned";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized constructor
    Book1(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
    }
}

public class Book {
    public static void main(String[] args) {
        // Using default constructor
        Book1 b1 = new Book1();
        b1.display();

        System.out.println();

        // Using parameterized constructor
        Book1 b2 = new Book1("Java Basics", "James Gosling", 499.99);
        b2.display();
    }
}

