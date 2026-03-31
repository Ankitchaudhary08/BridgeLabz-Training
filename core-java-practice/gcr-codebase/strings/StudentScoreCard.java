import java.util.Scanner;

public class StudentScoreCard {

    // a) Generate random 2-digit PCM scores
    public static int[][] generateScores(int students) {
        int[][] pcm = new int[students][3];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                pcm[i][j] = 10 + (int) (Math.random() * 90); // 2-digit marks
            }
        }
        return pcm;
    }

    // b) Calculate total, average, percentage
    public static double[][] calculateResults(int[][] pcm) {
        int students = pcm.length;
        double[][] result = new double[students][3]; // total, average, percentage

        for (int i = 0; i < students; i++) {
            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;

            result[i][0] = Math.round(total * 100.0) / 100.0;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return result;
    }

    // c) Calculate grade
    public static String[] calculateGrades(double[][] result) {
        String[] grades = new String[result.length];

        for (int i = 0; i < result.length; i++) {
            double p = result[i][2];

            if (p >= 80) grades[i] = "A";
            else if (p >= 70) grades[i] = "B";
            else if (p >= 60) grades[i] = "C";
            else if (p >= 50) grades[i] = "D";
            else if (p >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    // d) Display scorecard
    public static void displayScoreCard(int[][] pcm, double[][] result, String[] grades) {
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        for (int i = 0; i < pcm.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                    pcm[i][0] + "\t" +
                    pcm[i][1] + "\t" +
                    pcm[i][2] + "\t" +
                    result[i][0] + "\t" +
                    result[i][1] + "\t" +
                    result[i][2] + "\t" +
                    grades[i]
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] pcm = generateScores(n);
        double[][] result = calculateResults(pcm);
        String[] grades = calculateGrades(result);

        displayScoreCard(pcm, result, grades);
    }
}
