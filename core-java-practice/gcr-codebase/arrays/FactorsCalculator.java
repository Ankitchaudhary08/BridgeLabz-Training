import java.util.Scanner;

public class FactorsCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Create integer variable maxFactor and initialize to 10
        int maxFactor = 10;
        
        // factors array of size maxFactor
        int[] factors = new int[maxFactor];
        
        // index variable to reflect the index of the array
        int index = 0;

        // To find factors loop through the numbers from 1 to the number
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // If the index is equal to maxFactor, then need factors array to store more elements
                if (index == maxFactor) {
                    // Reset the maxFactor to twice its size
                    maxFactor = maxFactor * 2;
                    
                    // Use the temp array to store the elements from the factors array
                    int[] temp = new int[maxFactor];
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }
                    // Eventually assign the factors array to the temp array
                    factors = temp;
                }
                // Add them to the array element by incrementing the index
                factors[index] = i;
                index++;
            }
        }

        // Finally, Display the factors of the number
        System.out.print("Factors of " + number + " are: ");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();
    }
}