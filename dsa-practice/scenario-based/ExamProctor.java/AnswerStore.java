import java.util.HashMap;

// Stores answers using HashMap
public class AnswerStore {

    private HashMap<Integer, String> answers = new HashMap<>();

    // Save or update answer
    public void submitAnswer(int questionId, String answer) {
        answers.put(questionId, answer);
    }

    // Get answer of a question
    public String getAnswer(int questionId) {
        return answers.get(questionId);
    }

    // Get all answers
    public HashMap<Integer, String> getAllAnswers() {
        return answers;
    }
}
