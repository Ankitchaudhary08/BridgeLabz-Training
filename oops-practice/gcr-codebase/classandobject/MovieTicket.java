class MovieTicket {

    String movieName;
    String seatNumber;
    double price;
    boolean isBooked = false;

    // this method book ticket if not already booked
    void bookTicket(String movieName, String seatNumber, double price) {

        if (!isBooked) {
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.price = price;
            isBooked = true;

            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }

    // this method display ticket details
    void displayTicketDetails() {

        if (!isBooked) {
            System.out.println("Ticket have not booked yet....");
        } else {
            System.out.println("Price: $" + price);
            System.out.println();
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }

    public static void main(String[] args) {

        MovieTicket ticket = new MovieTicket();

        // before booking
        ticket.displayTicketDetails();

        // first booking
        ticket.bookTicket("Dragon", "A10", 120.0);

        // try to book again
        ticket.bookTicket("Dragon", "A11", 120.0);
        ticket.bookTicket("Dragon", "A12", 120.0);

        // display final ticket info
        ticket.displayTicketDetails();
    }
}
