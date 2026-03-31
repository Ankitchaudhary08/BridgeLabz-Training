public class SpringSeason {

    // this method check spring season or not
    public static boolean checkSpring(int month, int day) {

        // spring season start from march 20 and end june 20
        if ((month == 3 && day >= 20) ||
            (month == 4) ||
            (month == 5) ||
            (month == 6 && day <= 20)) {

            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        // taking input from command line
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // calling method to check season
        boolean isSpring = checkSpring(month, day);

        // printing output
        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
