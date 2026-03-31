// Circular Linked List Node (Ticket)
class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;

    TicketNode next;

    TicketNode(int ticketId, String customerName, String movieName,
               String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

// Online Ticket Reservation System using Circular Linked List
class TicketReservationSystem {

    private TicketNode head;
    private TicketNode tail;
    private int count = 0;

    // Add ticket at end
    public void addTicket(int id, String customer, String movie,
                          String seat, String time) {

        TicketNode newTicket =
            new TicketNode(id, customer, movie, seat, time);

        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }
        count++;
        System.out.println("Ticket booked successfully");
    }

    // Remove ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets available");
            return;
        }

        TicketNode curr = head;
        TicketNode prev = tail;

        do {
            if (curr.ticketId == ticketId) {

                // Only one ticket
                if (curr == head && curr == tail) {
                    head = tail = null;
                }
                // Removing head
                else if (curr == head) {
                    head = head.next;
                    tail.next = head;
                }
                // Removing tail
                else if (curr == tail) {
                    tail = prev;
                    tail.next = head;
                }
                // Removing middle ticket
                else {
                    prev.next = curr.next;
                }

                count--;
                System.out.println("Ticket removed");
                return;
            }

            prev = curr;
            curr = curr.next;

        } while (curr != head);

        System.out.println("Ticket not found");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No booked tickets");
            return;
        }

        TicketNode temp = head;
        System.out.println("Current Tickets:");

        do {
            System.out.println(
                temp.ticketId + " | " +
                temp.customerName + " | " +
                temp.movieName + " | Seat: " +
                temp.seatNumber + " | Time: " +
                temp.bookingTime
            );
            temp = temp.next;
        } while (temp != head);
    }

    // Search ticket by customer name
    public void searchByCustomer(String customerName) {
        if (head == null) {
            System.out.println("No tickets available");
            return;
        }

        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No ticket found for this customer");
    }

    // Search ticket by movie name
    public void searchByMovie(String movieName) {
        if (head == null) {
            System.out.println("No tickets available");
            return;
        }

        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No ticket found for this movie");
    }

    // Count total tickets
    public int totalTickets() {
        return count;
    }

    private void displayTicket(TicketNode t) {
        System.out.println(
            t.ticketId + " | " +
            t.customerName + " | " +
            t.movieName + " | Seat: " +
            t.seatNumber + " | Time: " +
            t.bookingTime
        );
    }
}

// Class name is NOT Main
public class TicketApp {
    public static void main(String[] args) {

        TicketReservationSystem system =
            new TicketReservationSystem();

        system.addTicket(101, "Ankit", "Inception", "A1", "10:00 AM");
        system.addTicket(102, "Ravi", "Inception", "A2", "10:05 AM");
        system.addTicket(103, "Neha", "Avatar", "B1", "10:10 AM");

        system.displayTickets();

        System.out.println("\nSearch by Customer:");
        system.searchByCustomer("Ankit");

        System.out.println("\nSearch by Movie:");
        system.searchByMovie("Inception");

        system.removeTicket(102);

        System.out.println("\nAfter Removal:");
        system.displayTickets();

        System.out.println("\nTotal Tickets Booked = "
                + system.totalTickets());
    }
}
