import java.util.*;

public class QuizPerformanceRanking {

    static class Student {
        String name, department;
        int q1, q2, q3, total;
        int index;

        Student(String name, String department, int q1, int q2, int q3, int index) {
            this.name = name;
            this.department = department;
            this.q1 = q1;
            this.q2 = q2;
            this.q3 = q3;
            this.total = q1 + q2 + q3;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Student> students = new ArrayList<>();
        int idx = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");
            String op = parts[0];

            if (op.equals("Record")) {
                String name = parts[1];
                String dept = parts[2];
                int q1 = Integer.parseInt(parts[3]);
                int q2 = Integer.parseInt(parts[4]);
                int q3 = Integer.parseInt(parts[5]);
                students.add(new Student(name, dept, q1, q2, q3, idx++));
                System.out.println("Record Added: " + name);
            } else if (op.equals("Top")) {
                String param = parts[1];

                if (param.equals("Q1") || param.equals("Q2") || param.equals("Q3")) {
                    int quizNum = Integer.parseInt(param.substring(1));
                    int maxScore = Integer.MIN_VALUE;
                    for (Student s : students) {
                        int score = quizNum == 1 ? s.q1 : quizNum == 2 ? s.q2 : s.q3;
                        maxScore = Math.max(maxScore, score);
                    }
                    if (students.isEmpty()) {
                        System.out.println("No Records Available");
                    } else {
                        for (Student s : students) {
                            int score = quizNum == 1 ? s.q1 : quizNum == 2 ? s.q2 : s.q3;
                            if (score == maxScore) {
                                System.out.println(s.name + " " + score);
                            }
                        }
                    }
                } else {
                    // Department
                    String dept = param;
                    List<Student> deptStudents = new ArrayList<>();
                    for (Student s : students) {
                        if (s.department.equals(dept)) deptStudents.add(s);
                    }
                    if (deptStudents.isEmpty()) {
                        System.out.println("Department Not Found");
                    } else {
                        int maxTotal = Integer.MIN_VALUE;
                        for (Student s : deptStudents) maxTotal = Math.max(maxTotal, s.total);
                        for (Student s : deptStudents) {
                            if (s.total == maxTotal) System.out.println(s.name + " " + s.total);
                        }
                    }
                }
            }
        }
        sc.close();
    }
}
