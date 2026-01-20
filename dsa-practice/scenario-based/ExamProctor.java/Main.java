import java.util.HashMap;

// Main class to simulate exam
public class Main {

    public static void main(String[] args) {

        NavigationStack navigation = new NavigationStack();
        AnswerStore store = new AnswerStore();

        // Correct answers (exam answer key)
        HashMap<Integer, String> correctAnswers = new HashMap<>();
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "B");
        correctAnswers.put(3, "C");

        // Student navigation
        navigation.visitQuestion(1);
        store.submitAnswer(1, "A");

        navigation.visitQuestion(2);
        store.submitAnswer(2, "B");

        navigation.visitQuestion(3);
        store.submitAnswer(3, "D"); // wrong answer

        // Student submits exam → score calculated
        int score = ScoreCalculator.calculateScore(
                store.getAllAnswers(),
                correctAnswers
        );

        System.out.println("Final Score: " + score);
    }
}
