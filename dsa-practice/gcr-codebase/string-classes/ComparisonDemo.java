import java.io.*;
import java.nio.charset.StandardCharsets;

public class ComparisonDemo {

    public static void main(String[] args) throws Exception {

        int n = 1_000_000;
        String text = "hello";

        /* -------------------------------
           StringBuilder vs StringBuffer
        -------------------------------- */

        // StringBuilder
        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(text);
        }
        long endBuilder = System.nanoTime();

        // StringBuffer
        long startBuffer = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbuf.append(text);
        }
        long endBuffer = System.nanoTime();

        System.out.println("StringBuilder Time (ns): " + (endBuilder - startBuilder));
        System.out.println("StringBuffer Time (ns): " + (endBuffer - startBuffer));

        /* -------------------------------
           FileReader vs InputStreamReader
        -------------------------------- */

        String filePath = "largefile.txt"; // assume ~100MB file

        // FileReader
        long startFR = System.nanoTime();
        int wordsFR = countWordsUsingFileReader(filePath);
        long endFR = System.nanoTime();

        // InputStreamReader
        long startISR = System.nanoTime();
        int wordsISR = countWordsUsingInputStreamReader(filePath);
        long endISR = System.nanoTime();

        System.out.println("\nFileReader Word Count: " + wordsFR);
        System.out.println("FileReader Time (ns): " + (endFR - startFR));

        System.out.println("\nInputStreamReader Word Count: " + wordsISR);
        System.out.println("InputStreamReader Time (ns): " + (endISR - startISR));
    }

    // -------- FileReader --------
    public static int countWordsUsingFileReader(String path) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        int count = 0;

        while ((line = br.readLine()) != null) {
            count += line.split("\\s+").length;
        }
        br.close();
        return count;
    }

    // -------- InputStreamReader --------
    public static int countWordsUsingInputStreamReader(String path) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path),
                        StandardCharsets.UTF_8));

        String line;
        int count = 0;

        while ((line = br.readLine()) != null) {
            count += line.split("\\s+").length;
        }
        br.close();
        return count;
    }
}
