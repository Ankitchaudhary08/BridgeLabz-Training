
import java.util.ArrayList;
import java.util.List;

class CinemaTime {

    private List<String> movieTitles = new ArrayList<>();
    private List<String> movieTimes = new ArrayList<>();

    //  Add movie
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        movieTitles.add(title);
        movieTimes.add(time);
    }

    //  Search movie
    public void searchMovie(String keyword) {
        try {
            boolean found = false;
            for (int i = 0; i < movieTitles.size(); i++) {
                if (movieTitles.get(i).contains(keyword)) {
                    System.out.println(
                        String.format("Movie: %s | Time: %s",
                        movieTitles.get(i),
                        movieTimes.get(i))
                    );
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No movie found with keyword: " + keyword);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid movie index accessed");
        }
    }

    //  Display all movies
    public void displayAllMovies() {
        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.println(
                movieTitles.get(i) + " -> " + movieTimes.get(i)
            );
        }
    }

    //  Convert List to Array (for report)
    public void generateReport() {
        String[] titlesArray = movieTitles.toArray(new String[0]);
        String[] timesArray = movieTimes.toArray(new String[0]);

        System.out.println("---- Movie Report ----");
        for (int i = 0; i < titlesArray.length; i++) {
            System.out.println(titlesArray[i] + " at " + timesArray[i]);
        }
    }

    // Helper method to check time format (HH:MM)
    private boolean isValidTime(String time) {
        if (!time.matches("\\d{2}:\\d{2}"))
            return false;

        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));

        return hour >= 0 && hour < 24 && minute >= 0 && minute < 60;
    }
}
