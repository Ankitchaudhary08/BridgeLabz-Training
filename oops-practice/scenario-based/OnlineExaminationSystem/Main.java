package OnlineExaminationSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Student student = new Student(1, "Ankit");

        Exam exam = new Exam("Java Test", 60000);
        exam.addQuestion(new Question("What is JVM?", "Java Virtual Machine"));
        exam.addQuestion(new Question("What is OOP?", "Object Oriented Programming"));

        exam.startExam();

        List<String> answers = new ArrayList<>();
        answers.add("Java Virtual Machine");
        answers.add("Object Oriented Programming");

        EvaluationStrategy strategy = new ObjectiveEvaluation();
        OnlineExamService service = new OnlineExamService(strategy);

        try {
            int score = service.submitExam(exam, answers);
            System.out.println("Student: " + student.getName());
            System.out.println("Score: " + score);
        } catch (ExamTimeExpiredException e) {
            System.out.println(e.getMessage());
        }
    }
}

