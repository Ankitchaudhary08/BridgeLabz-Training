import java.util.ArrayList;
import java.util.List;

// Custom Exception
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// Book class (Model)
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkout() throws BookNotAvailableException {
        if (!isAvailable) {
            throw new BookNotAvailableException("Book is already checked out.");
        }
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }
}

// Library class (Logic)
class Library {

    private List<Book> books = new ArrayList<>();

    // Load books from array into List
    public void addBooks(Book[] bookArray) {
        for (Book b : bookArray) {
            books.add(b);
        }
    }

    // Search book by partial title
    public void searchByTitle(String keyword) {
        System.out.println("\nSearch Results:");
        boolean found = false;

        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                displayBook(b);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found with given title.");
        }
    }

    // Checkout book
    public void checkoutBook(String title) throws BookNotAvailableException {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.checkout();
                System.out.println("Book checked out successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Display single book
    private void displayBook(Book b) {
        System.out.println("---------------------------");
        System.out.println("Title  : " + b.getTitle());
        System.out.println("Author : " + b.getAuthor());
        System.out.println("Status : " + (b.isAvailable() ? "Available" : "Checked Out"));
    }

    // Display all books
    public void displayAllBooks() {
        System.out.println("\nLibrary Books:");
        for (Book b : books) {
            displayBook(b);
        }
    }
}

// Application class
public class LibraryApp {

    public static void main(String[] args) {

        // Book data stored in Array
        Book[] bookArray = {
                new Book("Java Programming", "James Gosling", true),
                new Book("Clean Code", "Robert Martin", true),
                new Book("Data Structures", "Mark Allen", false)
        };

        Library library = new Library();
        library.addBooks(bookArray);

        library.displayAllBooks();

        library.searchByTitle("java");

        try {
            library.checkoutBook("Clean Code");
            library.checkoutBook("Data Structures"); // already unavailable
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        library.displayAllBooks();
    }
}
