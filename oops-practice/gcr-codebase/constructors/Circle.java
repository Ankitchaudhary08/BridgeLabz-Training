class Cir {
    double radius;

    // Default constructor
    Cir() {
        this(1.0);   // calling parameterized constructor
    }

    // Parameterized constructor
    Cir(double radius) {
        this.radius = radius;
    }

    void display() {
        System.out.println("Radius: " + radius);
    }
}

public class Circle {
    public static void main(String[] args) {

        // Using default constructor
        Cir c1 = new Cir();
        c1.display();

        // Using parameterized constructor
        Cir c2 = new Cir(5.5);
        c2.display();
    }
}
