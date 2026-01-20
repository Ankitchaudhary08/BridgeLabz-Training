// One node represents one visited page
public class HistoryNode {

    String url;              // Page URL
    HistoryNode prev;        // Previous page
    HistoryNode next;        // Next page

    // Create a history node
    public HistoryNode(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}
