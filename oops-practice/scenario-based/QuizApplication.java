import java.util.ArrayList;
import java.util.List;

// Custom Exception
class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

// Quiz logic class
class QuizResultProcessor {

    // Compare answers and calculate score
    public int calculateScore(String[] correctAnswers, String[] userAnswers)
            throws InvalidQuizSubmissionException {

        // Validate input length
        if (correctAnswers.length != userAnswers.length) {
            throw new InvalidQuizSubmissionException(
                "Answer count does not match question count."
            );
        }

        int score = 0;

        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }

    // Return grade based on score
    public String getGrade(int score, int totalQuestions) {

        double percentage = (score * 100.0) / totalQuestions;

        if (percentage >= 80) {
            return "A";
        } else if (percentage >= 60) {
            return "B";
        } else if (percentage >= 40) {
            return "C";
        } else {
            return "Fail";
        }
    }
}

// Application class
public class QuizApplication {

    public static void main(String[] args) {

        String[] correctAnswers = {"A", "C", "B", "D", "A"};

        String[] user1Answers = {"A", "C", "B", "D", "A"};
        String[] user2Answers = {"A", "B", "B", "D", "C"};

        QuizResultProcessor processor = new QuizResultProcessor();
        List<Integer> scores = new ArrayList<>();

        try {
            int score1 = processor.calculateScore(correctAnswers, user1Answers);
            scores.add(score1);
            System.out.println("User 1 Score: " + score1);
            System.out.println("User 1 Grade: " +
                    processor.getGrade(score1, correctAnswers.length));

            int score2 = processor.calculateScore(correctAnswers, user2Answers);
            scores.add(score2);
            System.out.println("\nUser 2 Score: " + score2);
            System.out.println("User 2 Grade: " +
                    processor.getGrade(score2, correctAnswers.length));

        } catch (InvalidQuizSubmissionException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAll Users Scores: " + scores);
    }
}
