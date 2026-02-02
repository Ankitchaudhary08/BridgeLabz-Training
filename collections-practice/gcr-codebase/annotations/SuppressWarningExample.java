import java.util.ArrayList;

public class SuppressWarningExample {

    public static void main(String[] args) {

        // Suppress unchecked warning for this block
        @SuppressWarnings("unchecked")
        ArrayList list = new ArrayList();   // Raw type

        list.add(10);
        list.add("Hello");
        list.add(20.5);

        System.out.println(list);
    }
}
