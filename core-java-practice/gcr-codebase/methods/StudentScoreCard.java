import java.util.Scanner;
import java.util.Random;

public class StudentScoreCard {

    // this method generate random 2 digit marks for PCM
    public static int[][] generateMarks(int students) {

        int[][] pcm = new int[students][3];
        Random rand = new Random();

        for (int i = 0; i < students; i++) {
            // generating random marks between 10 to 99
            pcm[i][0] = 10 + rand.nextInt(90); // Physics
            pcm[i][1] = 10 + rand.nextInt(90); // Chemistry
            pcm[i][2] = 10 + rand.nextInt(90); // Maths
        }
        return pcm;
    }

    // this method calculate total, average and percentage
    public static double[][] calculateResult(int[][] pcm) {

        double[][] result = new double[pcm.length][3];
        // col 0 -> total, col 1 -> average, col 2 -> percentage

        for (int i = 0; i < pcm.length; i++) {

            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double avg = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // rounding off to 2 digits
            result[i][0] = Math.round(total * 100.0) / 100.0;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return result;
    }

    // this method assign grade based on percentage
    public static String getGrade(double percentage) {

        if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "R";
        }
    }

    // this method display scorecard in tabular format
    public static void displayScoreCard(int[][] pcm, double[][] result) {

        System.out.println("\nID\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < pcm.length; i++) {

            String grade = getGrade(result[i][2]);

            System.out.println(
                    (i + 1) + "\t" +
                    pcm[i][0] + "\t" +
                    pcm[i][1] + "\t" +
                    pcm[i][2] + "\t" +
                    result[i][0] + "\t" +
                    result[i][1] + "\t" +
                    result[i][2] + "\t" +
                    grade
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking number of students
        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        int[][] pcmMarks = generateMarks(students);
        double[][] finalResult = calculateResult(pcmMarks);

        displayScoreCard(pcmMarks, finalResult);

        sc.close();
    }
}
