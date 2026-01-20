import java.util.Stack;

// Stores closed tabs for reopening
public class ClosedTabsStack {

    private Stack<String> closedTabs = new Stack<>();

    // Save closed tab
    public void closeTab(String url) {
        closedTabs.push(url);
    }

    // Restore last closed tab
    public String reopenTab() {
        if (closedTabs.isEmpty()) {
            return null;
        }
        return closedTabs.pop();
    }
}
