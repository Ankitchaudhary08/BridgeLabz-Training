import java.util.ArrayList;
import java.util.List;

// Custom Exception
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

// Contact class
class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

// Contact Organizer class
class ContactOrganizer {

    private List<Contact> contacts = new ArrayList<>();

    // Validate phone number
    private void validatePhone(String phone)
            throws InvalidPhoneNumberException {

        if (!phone.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException(
                "Phone number must be exactly 10 digits"
            );
        }
    }

    // Add contact
    public void addContact(String name, String phone)
            throws InvalidPhoneNumberException {

        validatePhone(phone);

        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                System.out.println("Duplicate contact not allowed.");
                return;
            }
        }

        contacts.add(new Contact(name, phone));
        System.out.println("Contact added successfully.");
    }

    // Delete contact
    public void deleteContact(String phone) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                contacts.remove(c);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Search contact
    public void searchContact(String phone) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                System.out.println("Name : " + c.getName());
                System.out.println("Phone: " + c.getPhoneNumber());
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}

// Application class (NOT Main)
public class ContactApp {

    public static void main(String[] args) {

        ContactOrganizer organizer = new ContactOrganizer();

        try {
            organizer.addContact("Ankit", "9876543210");
            organizer.addContact("Rahul", "9876543210"); // duplicate
            organizer.addContact("Aman", "12345");       // invalid
        } catch (InvalidPhoneNumberException e) {
            System.out.println(e.getMessage());
        }

        organizer.searchContact("9876543210");
        organizer.deleteContact("9876543210");
        organizer.searchContact("9876543210");
    }
}
