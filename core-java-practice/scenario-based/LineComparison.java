public class LineComparison {

    // method to calculate length of a line using two points
    private static Double calculateLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt(
                Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)
        );
    }

    public static void main(String[] args) {

        // Welcome message on Master Branch
        System.out.println("Welcome to Line Comparison Computation Program");

        // Line 1 coordinates
        int x1 = 2, y1 = 3;
        int x2 = 6, y2 = 7;

        // Line 2 coordinates
        int x3 = 1, y3 = 4;
        int x4 = 5, y4 = 8;

        // calculate lengths
        Double line1Length = calculateLength(x1, y1, x2, y2);
        Double line2Length = calculateLength(x3, y3, x4, y4);

        // UC 1: check equality using equals()
        if (line1Length.equals(line2Length)) {
            System.out.println("Both lines are Equal");
        } else {
            System.out.println("Both lines are Not Equal");
        }

        // UC 2: compare using compareTo()
        int comparisonResult = line1Length.compareTo(line2Length);

        if (comparisonResult > 0) {
            System.out.println("Line 1 is Greater than Line 2");
        } else if (comparisonResult < 0) {
            System.out.println("Line 1 is Less than Line 2");
        } else {
            System.out.println("Both lines are Equal");
        }

        // program ends here
    }
}
