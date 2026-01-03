class Book {
    String title;
    String author;
    boolean isAvailable;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}

public class LibrarySystem {

    // Display all books
    static void displayBooks(Book[] books) {
        for (Book b : books) {
            System.out.println("Title: " + b.title);
            System.out.println("Author: " + b.author);
            System.out.println("Status: " + (b.isAvailable ? "Available" : "Checked Out"));
            System.out.println();
        }
    }

    // Search book by partial title
    static void searchBook(Book[] books, String keyword) {
        boolean found = false;

        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Book Found:");
                System.out.println("Title: " + b.title);
                System.out.println("Author: " + b.author);
                System.out.println("Status: " + (b.isAvailable ? "Available" : "Checked Out"));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found with given title.");
        }
        System.out.println();
    }

    // Checkout or return book
    static void updateBookStatus(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (b.isAvailable) {
                    b.isAvailable = false;
                    System.out.println("Book checked out successfully.");
                } else {
                    b.isAvailable = true;
                    System.out.println("Book returned successfully.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Main method
    public static void main(String[] args) {

        Book[] books = new Book[3];
        books[0] = new Book("Effective Java", "Joshua Bloch");
        books[1] = new Book("Clean Code", "Robert Martin");
        books[2] = new Book("Java Basics", "James Gosling");

        System.out.println("All Books:");
        displayBooks(books);

        searchBook(books, "java");

        updateBookStatus(books, "Effective Java");

        System.out.println("\nUpdated Book List:");
        displayBooks(books);
    }
}
