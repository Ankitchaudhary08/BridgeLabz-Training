import java.util.*;

class ZeroSumSubarrays {

    static void findSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // To handle sum = 0 from index 0
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    System.out.println(
                        "Subarray found from index " + (startIndex + 1) + " to " + i
                    );
                }
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4};

        findSubarrays(arr);
    }
}
