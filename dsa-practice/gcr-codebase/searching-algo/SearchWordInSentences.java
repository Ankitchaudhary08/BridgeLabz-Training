public class SearchWordInSentences {

    public static String findSentence(String[] sentences, String word) {

        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence; // first match
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {

        String[] sentences = {
                "Java is easy to learn",
                "I love programming",
                "Linear search is simple",
                "Data structures are important"
        };

        String word = "search";

        String result = findSentence(sentences, word);
        System.out.println(result);
    }
}
