// Main class to test library system
public class BookShelf {

    public static void main(String[] args) {

        LibraryShelf library = new LibraryShelf();

        Book b1 = new Book("Clean Code", "Robert Martin");
        Book b2 = new Book("Effective Java", "Joshua Bloch");
        Book b3 = new Book("The Hobbit", "J.R.R. Tolkien");

        // Add books
        library.addBook("Programming", b1);
        library.addBook("Programming", b2);
        library.addBook("Fantasy", b3);

        // Try duplicate
        library.addBook("Programming", b1);

        library.printLibrary();

        // Borrow a book
        library.borrowBook("Programming", b2);

        library.printLibrary();

        // Return a book
        library.returnBook("Programming", b2);

        library.printLibrary();
    }
}
