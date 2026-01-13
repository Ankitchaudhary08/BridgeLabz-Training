package OnlineExaminationSystem;

import java.util.List;

public class OnlineExamService {

    private EvaluationStrategy evaluationStrategy;

    public OnlineExamService(EvaluationStrategy evaluationStrategy) {
        this.evaluationStrategy = evaluationStrategy;
    }

    public int submitExam(Exam exam, List<String> answers)
            throws ExamTimeExpiredException {

        if (exam.isTimeExpired()) {
            throw new ExamTimeExpiredException("Exam time has expired");
        }

        return evaluationStrategy.evaluate(
                exam.getQuestions(),
                answers
        );
    }
}

