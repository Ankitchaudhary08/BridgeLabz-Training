import java.util.HashMap;

// Contains function to calculate score
public class ScoreCalculator {

    // Auto-calculate score
    public static int calculateScore(
            HashMap<Integer, String> studentAnswers,
            HashMap<Integer, String> correctAnswers) {

        int score = 0;

        for (int questionId : correctAnswers.keySet()) {

            // Compare correct answer with student answer
            if (correctAnswers.get(questionId)
                    .equals(studentAnswers.get(questionId))) {
                score++;
            }
        }
        return score;
    }
}
