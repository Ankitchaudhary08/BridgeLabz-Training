import java.util.Scanner;

public class BasicCalculator {

    static int add(int a, int b) { return a + b; }
    static int sub(int a, int b) { return a - b; }
    static int mul(int a, int b) { return a * b; }
    static int div(int a, int b) { return a / b; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print("Choose operation (+ - * /): ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+': System.out.println(add(a, b)); break;
            case '-': System.out.println(sub(a, b)); break;
            case '*': System.out.println(mul(a, b)); break;
            case '/': System.out.println(div(a, b)); break;
        }

        sc.close();
    }
}
