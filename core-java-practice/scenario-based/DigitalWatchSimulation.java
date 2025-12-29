public class DigitalWatchSimulation {

    public static void main(String[] args) {

        // simulate 24 hour digital watch
        for (int hour = 0; hour < 24; hour++) {

            for (int minute = 0; minute < 60; minute++) {

                // print time in HH:MM format
                System.out.printf("%02d:%02d\n", hour, minute);

                // power cut happen exactly at 13:00
                if (hour == 13 && minute == 0) {
                    System.out.println("Power cut! Watch stopped.");
                    break; // break minute loop
                }
            }

            // also stop hour loop when power cut
            if (hour == 13) {
                break;
            }
        }

        // watch simulation end
    }
}
