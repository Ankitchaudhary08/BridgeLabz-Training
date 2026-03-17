import java.util.*;

public class FestivalManagementSystem {

    abstract static class Festival {
        String name, location, date;

        Festival(String name, String location, String date) {
            this.name = name;
            this.location = location;
            this.date = date;
        }

        abstract void display();
    }

    static class MusicFestival extends Festival {
        String headliner, musicGenre;
        int ticketPrice;

        MusicFestival(String name, String location, String date, String headliner, String musicGenre, int ticketPrice) {
            super(name, location, date);
            this.headliner = headliner;
            this.musicGenre = musicGenre;
            this.ticketPrice = ticketPrice;
        }

        @Override
        void display() {
            System.out.println("Festival Name: " + name);
            System.out.println("Location: " + location);
            System.out.println("Date: " + date);
            System.out.println("Headliner: " + headliner);
            System.out.println("Music Genre: " + musicGenre);
            System.out.println("Ticket Price: " + ticketPrice);
            System.out.println();
        }
    }

    static class FoodFestival extends Festival {
        String cuisine;
        int numStalls, entryFee;

        FoodFestival(String name, String location, String date, String cuisine, int numStalls, int entryFee) {
            super(name, location, date);
            this.cuisine = cuisine;
            this.numStalls = numStalls;
            this.entryFee = entryFee;
        }

        @Override
        void display() {
            System.out.println("Festival Name: " + name);
            System.out.println("Location: " + location);
            System.out.println("Date: " + date);
            System.out.println("Cuisine: " + cuisine);
            System.out.println("Number of Stalls: " + numStalls);
            System.out.println("Entry Fee: " + entryFee);
            System.out.println();
        }
    }

    static class ArtFestival extends Festival {
        String artType;
        int numArtists, exhibitionFee;

        ArtFestival(String name, String location, String date, String artType, int numArtists, int exhibitionFee) {
            super(name, location, date);
            this.artType = artType;
            this.numArtists = numArtists;
            this.exhibitionFee = exhibitionFee;
        }

        @Override
        void display() {
            System.out.println("Festival Name: " + name);
            System.out.println("Location: " + location);
            System.out.println("Date: " + date);
            System.out.println("Art Type: " + artType);
            System.out.println("Number of Artists: " + numArtists);
            System.out.println("Exhibition Fee: " + exhibitionFee);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Festival> festivals = new LinkedHashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.equals("EXIT")) break;

            String[] parts = line.split(" ");
            String command = parts[0];

            if (command.equals("ADD_FESTIVAL")) {
                String type = parts[1];
                String name = parts[2];
                String location = parts[3];
                String date = parts[4];

                if (type.equals("MUSIC")) {
                    String headliner = parts[5];
                    String genre = parts[6];
                    int price = Integer.parseInt(parts[7]);
                    festivals.put(name, new MusicFestival(name, location, date, headliner, genre, price));
                } else if (type.equals("FOOD")) {
                    String cuisine = parts[5];
                    int stalls = Integer.parseInt(parts[6]);
                    int fee = Integer.parseInt(parts[7]);
                    festivals.put(name, new FoodFestival(name, location, date, cuisine, stalls, fee));
                } else if (type.equals("ART")) {
                    String artType = parts[5];
                    int artists = Integer.parseInt(parts[6]);
                    int fee = Integer.parseInt(parts[7]);
                    festivals.put(name, new ArtFestival(name, location, date, artType, artists, fee));
                }
            } else if (command.equals("DISPLAY_DETAILS")) {
                String name = parts[1];
                if (festivals.containsKey(name)) {
                    festivals.get(name).display();
                }
            }
        }
        sc.close();
    }
}
