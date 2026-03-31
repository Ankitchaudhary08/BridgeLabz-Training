import java.util.*;
import java.util.stream.*;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "java is easy and java is powerful";
        Map<String, Integer> freq =
            Arrays.stream(paragraph.split(" "))
                  .collect(Collectors.toMap(
                      word -> word,          // key
                      word -> 1,             // value
                      Integer::sum           // merge if duplicate
                  ));
        System.out.println(freq);
    }
}
