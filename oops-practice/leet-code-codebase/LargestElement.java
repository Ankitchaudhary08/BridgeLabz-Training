class LargestElement {

    public static void main(String[] args) {

        int[] arr = {5, 12, 3, 25, 8};

        int largest = arr[0]; // assume first element is largest

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        System.out.println("Largest element is: " + largest);
    }
}
