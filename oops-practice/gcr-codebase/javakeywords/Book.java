class Book {

    // Static variable
    static String libraryName = "Egmore Library";

    // Instance variables
    String title;
    String author;
    final String isbn;   // final variable

    // Constructor using this
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details
    void displayDetails(Object obj) {
        if (obj instanceof Book) {
            Book b = (Book) obj;
            System.out.println("Title: " + b.title);
            System.out.println("Author: " + b.author);
            System.out.println("ISBN: " + b.isbn);
        }
    }

    // Main method
    public static void main(String[] args) {
        Book book = new Book(
                "Effective Java",
                "Joshua Bloch",
                "978-0134685991"
        );

        displayLibraryName();
        book.displayDetails(book);
    }
}
