// Doubly Linked List Node (Text State)
class TextState {
    String content;
    TextState prev;
    TextState next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

// Text Editor with Undo / Redo
class TextEditor {

    private TextState head;
    private TextState tail;
    private TextState current;
    private int size;
    private final int MAX_HISTORY = 10;

    // Add new text state
    public void addState(String text) {
        TextState newState = new TextState(text);

        // If undo was used, remove redo history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = current = newState;
            size = 1;
            return;
        }

        tail.next = newState;
        newState.prev = tail;
        tail = newState;
        current = newState;
        size++;

        // Limit history size
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo operation
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo");
            return;
        }
        current = current.prev;
        System.out.println("Undo performed");
    }

    // Redo operation
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo");
            return;
        }
        current = current.next;
        System.out.println("Redo performed");
    }

    // Display current text
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("Editor is empty");
            return;
        }
        System.out.println("Current Text: " + current.content);
    }

    // Display full history (for understanding)
    public void displayHistoryForward() {
        TextState temp = head;
        System.out.println("Text History (Forward):");

        while (temp != null) {
            System.out.println(temp.content);
            temp = temp.next;
        }
    }

    public void displayHistoryReverse() {
        TextState temp = tail;
        System.out.println("Text History (Reverse):");

        while (temp != null) {
            System.out.println(temp.content);
            temp = temp.prev;
        }
    }
}

// Class name is NOT Main
public class TextEditorApp {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World!!");

        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("Hello World!!!");
        editor.displayCurrentState();

        editor.displayHistoryForward();
    }
}
