import java.util.*;

public class Two_sum_problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input target
        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        TwoSumSolution obj = new TwoSumSolution();
        int[] result = obj.twoSum(nums, target);

        // Output result
        System.out.println("Indexes are: " + result[0] + " , " + result[1]);
    }
}

class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // Store value and index
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];

            if (map.containsKey(val) && map.get(val) != i) {
                return new int[]{i, map.get(val)};
            }
        }

        return new int[]{-1, -1}; // if no solution
    }
}
