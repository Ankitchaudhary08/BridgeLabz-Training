public class NullPointerDemo {

    // Method to generate NullPointerException
    public static void generateException() {
        String text = null;
        System.out.println(text.length()); // Exception here
    }

    // Method to handle NullPointerException
    public static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled successfully");
        }
    }

    public static void main(String[] args) {

        // Call method that generates exception
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception occurred in generateException()");
        }

        // Call method that handles exception
        handleException();
    }
}
