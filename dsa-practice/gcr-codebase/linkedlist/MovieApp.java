// Doubly Linked List Node
class MovieNode {
    String title;
    String director;
    int year;
    double rating;

    MovieNode next;
    MovieNode prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

// Movie Management using Doubly Linked List
class MovieManager {

    private MovieNode head;
    private MovieNode tail;

    // Add at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add at end
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Remove movie by title
    public void removeByTitle(String title) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {

                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                System.out.println("Movie removed");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    // Search by director
    public void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movie found for this director");
        }
    }

    // Search by rating
    public void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movie found with this rating");
        }
    }

    // Update rating by title
    public void updateRating(String title, double newRating) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    // Display forward
    public void displayForward() {
        MovieNode temp = head;
        if (temp == null) {
            System.out.println("No movies available");
            return;
        }

        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        MovieNode temp = tail;
        if (temp == null) {
            System.out.println("No movies available");
            return;
        }

        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    private void displayMovie(MovieNode m) {
        System.out.println(
            m.title + " | " +
            m.director + " | " +
            m.year + " | Rating: " +
            m.rating
        );
    }
}

// Class name is NOT Main, but it has main method
public class MovieApp {
    public static void main(String[] args) {

        MovieManager manager = new MovieManager();

        manager.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        manager.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        manager.addAtEnd("Titanic", "James Cameron", 1997, 7.9);

        System.out.println("All Movies (Forward):");
        manager.displayForward();

        System.out.println("\nAll Movies (Reverse):");
        manager.displayReverse();

        System.out.println("\nSearch by Director:");
        manager.searchByDirector("Christopher Nolan");

        manager.updateRating("Titanic", 8.1);
        manager.removeByTitle("Inception");

        System.out.println("\nAfter Updates:");
        manager.displayForward();
    }
}
