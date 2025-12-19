import java.util.Scanner; // Import Scanner for input

public class AreaOfCircle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 

        // radius 
        System.out.print("Enter radius of the circle: ");
        double radius = sc.nextDouble();

      
        // Area = π × r × r
        double area = Math.PI * radius * radius;

        //output
        System.out.println("Area of Circle: " + area);
    }
}
