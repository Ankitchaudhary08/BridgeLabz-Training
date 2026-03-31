// Main class to simulate browser behavior
public class BrowserBuddy {

    public static void main(String[] args) {

        TabHistory history = new TabHistory();
        ClosedTabsStack closedTabs = new ClosedTabsStack();

        // Open pages
        history.visit("google.com");
        history.visit("github.com");
        history.visit("stackoverflow.com");

        System.out.println("Current Page: " + history.getCurrentPage());

        // Back navigation
        history.back();
        System.out.println("After Back: " + history.getCurrentPage());

        // Forward navigation
        history.forward();
        System.out.println("After Forward: " + history.getCurrentPage());

        // Close current tab
        closedTabs.closeTab(history.getCurrentPage());
        System.out.println("Tab closed");

        // Reopen last closed tab
        String restoredTab = closedTabs.reopenTab();
        if (restoredTab != null) {
            history.visit(restoredTab);
            System.out.println("Reopened Tab: " + history.getCurrentPage());
        }
    }
}
