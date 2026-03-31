import java.util.Scanner;

public class Remove_element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // size of array
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // elements of array
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // value to remove
        System.out.print("Enter value to remove: ");
        int val = sc.nextInt();

        RemoveSolution obj = new RemoveSolution();
        int k = obj.removeElement(nums, val);

        // result
        System.out.println("New length: " + k);
        System.out.print("Updated array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

class RemoveSolution {
    public int removeElement(int[] nums, int val) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
