public class Main {
    public static void main(String[] args) {

        CinemaTime cinema = new CinemaTime();

        try {
            cinema.addMovie("Avatar", "18:30");
            cinema.addMovie("Inception", "21:00");
            cinema.addMovie("Batman", "25:99"); //  Invalid time
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        cinema.displayAllMovies();
        cinema.searchMovie("Incep");
        cinema.generateReport();
    }
}
