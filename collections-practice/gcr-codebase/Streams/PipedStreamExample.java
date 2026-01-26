import java.io.*;

public class PipedStreamExample {

    public static void main(String[] args) {

        try {
            // Create piped streams
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream(pis);

            // Writer Thread
            Thread writer = new Thread(() -> {
                try {
                    String message = "Hello from Writer Thread";
                    pos.write(message.getBytes());
                    pos.close();
                } catch (IOException e) {
                    System.out.println("Writer IOException: " + e.getMessage());
                }
            });

            // Reader Thread
            Thread reader = new Thread(() -> {
                try {
                    int data;
                    while ((data = pis.read()) != -1) {
                        System.out.print((char) data);
                    }
                    pis.close();
                } catch (IOException e) {
                    System.out.println("Reader IOException: " + e.getMessage());
                }
            });

            // Start threads
            writer.start();
            reader.start();

        } catch (IOException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}
