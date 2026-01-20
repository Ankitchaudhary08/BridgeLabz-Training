import java.util.HashMap;
import java.util.LinkedList;
import java.util.HashSet;

// Manages genre-wise book storage
public class LibraryShelf {

    // genre → list of books
    private HashMap<String, LinkedList<Book>> catalog = new HashMap<>();

    // Prevent duplicate books
    private HashSet<Book> uniqueBooks = new HashSet<>();

    // Add book to library
    public void addBook(String genre, Book book) {

        // Avoid duplication
        if (!uniqueBooks.add(book)) {
            System.out.println("Duplicate book ignored: " + book);
            return;
        }

        // Create genre list if not present
        catalog.putIfAbsent(genre, new LinkedList<>());

        // Add book to genre list
        catalog.get(genre).add(book);
        System.out.println("Book added: " + book);
    }

    // Borrow a book (remove from list)
    public void borrowBook(String genre, Book book) {

        LinkedList<Book> books = catalog.get(genre);

        if (books == null || !books.remove(book)) {
            System.out.println("Book not available: " + book);
            return;
        }

        uniqueBooks.remove(book);
        System.out.println("Book borrowed: " + book);
    }

    // Return a book
    public void returnBook(String genre, Book book) {
        addBook(genre, book);
    }

    // Print entire library
    public void printLibrary() {

        if (catalog.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("Library Catalog:");
        for (String genre : catalog.keySet()) {
            System.out.println("Genre: " + genre);
            for (Book book : catalog.get(genre)) {
                System.out.println("  - " + book);
            }
        }
    }
}
