public class TemperatureAnalysis {

    public static void analyzeTemperature(float[][] temp) {

        float hottestAvg = Float.MIN_VALUE;
        float coldestAvg = Float.MAX_VALUE;

        int hottestDay = 0;
        int coldestDay = 0;

        float[] dailyAverage = new float[7];

        // Loop through days
        for (int day = 0; day < 7; day++) {
            float sum = 0;

            // Loop through 24 hours
            for (int hour = 0; hour < 24; hour++) {
                sum += temp[day][hour];
            }

            // Average for the day
            dailyAverage[day] = sum / 24;

            // Check hottest and coldest day
            if (dailyAverage[day] > hottestAvg) {
                hottestAvg = dailyAverage[day];
                hottestDay = day;
            }

            if (dailyAverage[day] < coldestAvg) {
                coldestAvg = dailyAverage[day];
                coldestDay = day;
            }
        }

        // Output
        System.out.println("Hottest Day: Day " + (hottestDay + 1)
                + " (Avg Temp: " + hottestAvg + ")");

        System.out.println("Coldest Day: Day " + (coldestDay + 1)
                + " (Avg Temp: " + coldestAvg + ")");

        System.out.println("\nAverage Temperature Per Day:");
        for (int i = 0; i < 7; i++) {
            System.out.println("Day " + (i + 1) + ": " + dailyAverage[i]);
        }
    }

    // Main method (test)
    public static void main(String[] args) {

        float[][] temperatures = {
                {30, 31, 29, 28, 27, 26, 25, 26, 28, 30, 32, 33,
                 34, 35, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27},

                {25, 26, 24, 23, 22, 21, 20, 21, 23, 25, 27, 28,
                 29, 30, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22},

                {32, 33, 31, 30, 29, 28, 27, 28, 30, 32, 34, 35,
                 36, 37, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29},

                {28, 29, 27, 26, 25, 24, 23, 24, 26, 28, 30, 31,
                 32, 33, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25},

                {26, 27, 25, 24, 23, 22, 21, 22, 24, 26, 28, 29,
                 30, 31, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23},

                {29, 30, 28, 27, 26, 25, 24, 25, 27, 29, 31, 32,
                 33, 34, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26},

                {31, 32, 30, 29, 28, 27, 26, 27, 29, 31, 33, 34,
                 35, 36, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28}
        };

        analyzeTemperature(temperatures);
    }
}
