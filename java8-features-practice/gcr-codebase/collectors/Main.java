import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Map<String, String>> students = List.of(
            Map.of("name", "Rahul", "grade", "A"),
            Map.of("name", "Aman",  "grade", "B"),
            Map.of("name", "Neha",  "grade", "A"),
            Map.of("name", "Priya", "grade", "C")
        );

        Map<String, List<String>> result =
            students.stream() 
                    .collect(Collectors.groupingBy(
                        s -> s.get("grade"),
                        Collectors.mapping(
                            s -> s.get("name"),
                            Collectors.toList()
                        )
                    ));

        System.out.println(result);
    }
}
