package OnlineExaminationSystem;

import java.util.ArrayList;
import java.util.List;

public class Exam {

    private String examName;
    private List<Question> questions;
    private long durationMillis;
    private long startTime;

    public Exam(String examName, long durationMillis) {
        this.examName = examName;
        this.durationMillis = durationMillis;
        this.questions = new ArrayList<>();
    }

    public void startExam() {
        startTime = System.currentTimeMillis();
    }

    public boolean isTimeExpired() {
        return System.currentTimeMillis() - startTime > durationMillis;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getExamName() {
        return examName;
    }
}

