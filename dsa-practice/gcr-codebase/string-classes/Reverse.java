import java.util.*;
public class Reverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        String str=sc.next();
        sb.append(str);
        sb.reverse();
        System.out.println(sb.toString());
        sc.close();

    }
    
}
