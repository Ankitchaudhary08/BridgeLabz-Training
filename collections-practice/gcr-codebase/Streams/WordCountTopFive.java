import java.io.*;
import java.util.*;

public class WordCountTopFive {

    public static void main(String[] args) {

        String filePath = "source.txt";

        // Map to store word count
        HashMap<String, Integer> wordCount = new HashMap<>();

        // Step 1 & 2: Read file and count words
        try (
            BufferedReader br = new BufferedReader(new FileReader(filePath))
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                // Convert to lowercase and remove special characters
                line = line.toLowerCase().replaceAll("[^a-z ]", "");

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // Step 3: Sort words by frequency
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(wordCount.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        // Step 4: Display top 5 words
        System.out.println("Top 5 most frequent words:");

        for (int i = 0; i < Math.min(5, list.size()); i++) {
            System.out.println(
                list.get(i).getKey() + " : " + list.get(i).getValue()
            );
        }
    }
}
