import java.util.Scanner;

public class FriendsCompare {

    // this method find youngest friend age
    public static int findYoungest(int[] age) {
        int min = age[0];

        for (int i = 1; i < age.length; i++) {
            if (age[i] < min) {
                min = age[i];
            }
        }
        return min;
    }

    // this method find tallest friend height
    public static int findTallest(int[] height) {
        int max = height[0];

        for (int i = 1; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] age = new int[3];
        int[] height = new int[3];

        String[] names = {"Amar", "Akbar", "Anthony"};

        // taking age and height of friends
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            age[i] = sc.nextInt();

            System.out.print("Enter height of " + names[i] + ": ");
            height[i] = sc.nextInt();
        }

        int youngest = findYoungest(age);
        int tallest = findTallest(height);

        System.out.println("Youngest friend age is " + youngest);
        System.out.println("Tallest friend height is " + tallest);

        sc.close();
    }
}
