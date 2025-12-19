import java.util.Scanner; 

public class VolumeOfCylinder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 

        // radius of cylinder
        System.out.print("Enter radius of cylinder: ");
        double radius = sc.nextDouble();

        // height of cylinder
        System.out.print("Enter height of cylinder: ");
        double height = sc.nextDouble();

        
        // Volume = π × r × r × h
        double volume = Math.PI * radius * radius * height;

        // result
        System.out.println("Volume of Cylinder: " + volume);
    }
}
