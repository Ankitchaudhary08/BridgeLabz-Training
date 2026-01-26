import java.io.*;

public class BufferedVsUnbuffered {

    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {

        String sourceFile = "source_large_file.dat";
        String unbufferedDest = "unbuffered_copy.dat";
        String bufferedDest = "buffered_copy.dat";

        // Unbuffered copy
        long unbufferedTime = copyUsingUnbufferedStreams(sourceFile, unbufferedDest);

        // Buffered copy
        long bufferedTime = copyUsingBufferedStreams(sourceFile, bufferedDest);

        System.out.println("\n--- Performance Result ---");
        System.out.println("Unbuffered Time (ns): " + unbufferedTime);
        System.out.println("Buffered Time   (ns): " + bufferedTime);
    }

    // Unbuffered Streams 
    private static long copyUsingUnbufferedStreams(String src, String dest) {
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Unbuffered copy error: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    //  Buffered Streams 
    private static long copyUsingBufferedStreams(String src, String dest) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Buffered copy error: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
