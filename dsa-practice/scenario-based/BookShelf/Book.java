// Represents a single book
public class Book {

    String title;
    String author;

    // Create a book
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Used by HashSet to avoid duplicate books
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;

        Book other = (Book) obj;
        return title.equals(other.title) && author.equals(other.author);
    }

    @Override
    public int hashCode() {
        return title.hashCode() + author.hashCode();
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}
