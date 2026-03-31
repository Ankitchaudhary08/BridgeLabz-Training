import java.util.Stack;

// Handles question navigation using Stack
public class NavigationStack {

    private Stack<Integer> questionStack = new Stack<>();

    // Visit a new question
    public void visitQuestion(int questionId) {
        questionStack.push(questionId);
    }

    // Go back to last visited question
    public Integer goBack() {
        if (questionStack.isEmpty()) {
            return null; // no previous question
        }
        return questionStack.pop();
    }

    // Check current question
    public Integer currentQuestion() {
        if (questionStack.isEmpty()) {
            return null;
        }
        return questionStack.peek();
    }
}
