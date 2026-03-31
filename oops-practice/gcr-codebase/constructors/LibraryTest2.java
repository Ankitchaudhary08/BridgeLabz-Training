// Parent class
class Book {
    // Access modifiers
    public String ISBN;
    protected String title;
    private String author;

    // Constructor
    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Setter method for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter method for author
    public String getAuthor() {
        return author;
    }
}

// Subclass
class EBook extends Book {

    EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    void displayDetails() {
        System.out.println("ISBN: " + ISBN);      // public → accessible
        System.out.println("Title: " + title);    // protected → accessible
        // System.out.println(author); ❌ not accessible (private)

        System.out.println("Author: " + getAuthor()); // access via public method
    }
}

public class LibraryTest2 {
    public static void main(String[] args) {

        EBook e1 = new EBook("978-0134685991", "Effective Java", "Joshua Bloch");

        e1.displayDetails();

        System.out.println("\nUpdating Author...");
        e1.setAuthor("J. Bloch");

        System.out.println("Updated Author: " + e1.getAuthor());
    }
}
