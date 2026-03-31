class Circle {

    double radius;

    // method to calculate area of circle
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    // method to calculate circumference of circle
    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    void displayResult() {
        System.out.printf("Area of circle: %.4f\n", calculateArea());
        System.out.printf("Circumference of circle: %.4f\n", calculateCircumference());
    }

    public static void main(String[] args) {

        Circle c = new Circle();

        // assigning radius value
        c.radius = 2.5;

        // display area and circumference
        c.displayResult();
    }
}
