import java.util.*;
import java.util.stream.*;

class Book {
    String genre;
    int pages;

    Book(String genre, int pages) {
        this.genre = genre;
        this.pages = pages;
    }

    String getGenre() { return genre; }
    int getPages() { return pages; }
}

public class BookStats {
    public static void main(String[] args) {

        List<Book> books = List.of(
            new Book("Fiction", 300),
            new Book("Fiction", 500),
            new Book("Science", 400)
        );

        Map<String, IntSummaryStatistics> stats =
            books.stream()
                 .collect(Collectors.groupingBy(
                     Book::getGenre,
                     Collectors.summarizingInt(Book::getPages)
                 ));
        stats.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });
    }
}
