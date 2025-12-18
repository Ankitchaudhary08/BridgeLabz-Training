 import java.util.Scanner; 

public class Perimeter_rectangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 

        // length of rectangle
        System.out.print("Enter length of rectangle: ");
        double length = sc.nextDouble();

        // breadth
        System.out.print("Enter breadth of rectangle: ");
        double breadth = sc.nextDouble();

       
        // Perimeter = 2 × (length + breadth)
        double perimeter = 2 * (length + breadth);

        // Print result
        System.out.println("Perimeter of Rectangle: " + perimeter);
    }

 
    
}
