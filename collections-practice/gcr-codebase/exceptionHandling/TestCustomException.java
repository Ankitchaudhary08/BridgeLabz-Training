public class TestCustomException {

    // static method
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age is not valid to vote");
        }
        System.out.println("Age is valid to vote");
    }

    public static void main(String[] args) {
        try {
            int age = 15;
            validateAge(age);
        } catch (InvalidAgeException ia) {
            System.out.println(ia.getMessage());
        }
    }
}

// Custom Exception class
class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}
