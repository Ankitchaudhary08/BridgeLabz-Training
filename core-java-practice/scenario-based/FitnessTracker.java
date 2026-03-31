public class FitnessTracker {

    public static void main(String[] args) {

        // Push-ups done in a week (0 means rest day)
        int[] pushUps = {30, 40, 0, 50, 60, 0, 70};

        int total = 0;
        int activeDays = 0;

        for (int count : pushUps) {

            if (count == 0) {
                continue; // skip rest day, no workout
            }

            total += count;
            activeDays++;
        }

        double average = (double) total / activeDays;

        System.out.println("Total Push-ups: " + total);
        System.out.println("Average Push-ups per active day: " + average);

        // simple fitness tracker program
    }
}
