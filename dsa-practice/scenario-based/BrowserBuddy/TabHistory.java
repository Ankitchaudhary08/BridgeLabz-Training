// Handles back and forward navigation using Doubly Linked List
public class TabHistory {

    private HistoryNode current; // Current page

    // Visit a new page
    public void visit(String url) {

        HistoryNode newPage = new HistoryNode(url);

        // First page visit
        if (current == null) {
            current = newPage;
            return;
        }

        // Cut forward history when new page is visited
        current.next = null;

        newPage.prev = current;
        current.next = newPage;
        current = newPage;
    }

    // Go back to previous page
    public void back() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No previous page.");
        }
    }

    // Go forward to next page
    public void forward() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No forward page.");
        }
    }

    // Get current page
    public String getCurrentPage() {
        return current == null ? "No page open" : current.url;
    }
}
