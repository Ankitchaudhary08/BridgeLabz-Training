public class EduQuiz {

    // Method to calculate score
    static int calculateScore(String[] correct, String[] student) {
        int score = 0;

        for (int i = 0; i < correct.length; i++) {
            if (correct[i].equalsIgnoreCase(student[i])) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {

        // Correct answers
        String[] correctAnswers = {
                "A", "C", "B", "D", "A",
                "B", "C", "D", "A", "B"
        };

        // Student answers
        String[] studentAnswers = {
                "a", "C", "b", "A", "A",
                "b", "D", "d", "A", "c"
        };

        int totalQuestions = correctAnswers.length;

        // Detailed feedback
        for (int i = 0; i < totalQuestions; i++) {
            if (correctAnswers[i].equalsIgnoreCase(studentAnswers[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }

        // Calculate score
        int score = calculateScore(correctAnswers, studentAnswers);
        double percentage = (score * 100.0) / totalQuestions;

        System.out.println("\nScore: " + score + "/" + totalQuestions);
        System.out.println("Percentage: " + percentage + "%");

        // Pass / Fail
        if (percentage >= 50) {
            System.out.println("Result: PASS ✅");
        } else {
            System.out.println("Result: FAIL ❌");
        }
    }
}
