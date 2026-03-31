public class CourseFeeDiscount {
    public static void main(String[] args) {

        // Original course fee
        double fee = 125000;

        // Discount percentage offered by university
        double discountPercent = 10;

        // Calculate discount amount
        double discountAmount = (fee * discountPercent) / 100;

        // Calculate final fee after discount
        double finalFee = fee - discountAmount;

        // Display result
        System.out.println(
            "The discount amount is INR " + discountAmount +
            " and final discounted fee is INR " + finalFee
        );
    }
}
