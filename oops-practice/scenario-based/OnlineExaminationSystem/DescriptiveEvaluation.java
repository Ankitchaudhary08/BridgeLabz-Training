package OnlineExaminationSystem;

import java.util.List;

public class DescriptiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(List<Question> questions, List<String> answers) {
        // Simple fixed marks logic
        return questions.size() * 2;
    }
}

