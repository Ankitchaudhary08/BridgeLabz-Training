import java.util.Scanner;

public class ReverseArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // taking size of array
        int n = sc.nextInt();

        int[] arr = new int[n];

        // taking array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int i = 0;
        int j = n - 1;

        // reversing the array
        while (j > i) {
            int a = arr[i];
            arr[i] = arr[j];
            arr[j] = a;
            i++;
            j--;
        }

        // printing reversed array
        for (int k = 0; k < n; k++) {
            System.out.print(arr[k] + " ");
        }

        sc.close();
    }
}
