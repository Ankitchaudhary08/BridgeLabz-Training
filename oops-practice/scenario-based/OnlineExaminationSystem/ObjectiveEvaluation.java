package OnlineExaminationSystem;

import java.util.List;

public class ObjectiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(List<Question> questions, List<String> answers) {
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getCorrectAnswer()
                    .equalsIgnoreCase(answers.get(i))) {
                score++;
            }
        }
        return score;
    }
}

