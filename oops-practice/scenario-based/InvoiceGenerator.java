public class InvoiceGenerator {

    // Method to parse invoice string
    public static String[] parseInvoice(String input) {
        // Split tasks by comma
        return input.split(",");
    }

    // Method to calculate total amount
    public static int getTotalAmount(String[] tasks) {

        int total = 0;

        for (String task : tasks) {

            // Example: "Logo Design - 3000 INR"
            String[] parts = task.split("-");

            // Amount part: "3000 INR"
            String amountPart = parts[1].trim();

            // Remove INR text
            amountPart = amountPart.replace("INR", "").trim();

            int amount = Integer.parseInt(amountPart);
            total += amount;
        }

        return total;
    }

    // Main method
    public static void main(String[] args) {

        String invoiceInput =
                "Logo Design - 3000 INR, Web Page - 4500 INR";

        // Step 1: Parse invoice
        String[] tasks = parseInvoice(invoiceInput);

        // Step 2: Print tasks
        System.out.println("Invoice Details:");
        for (String task : tasks) {
            System.out.println(task.trim());
        }

        // Step 3: Calculate total
        int totalAmount = getTotalAmount(tasks);

        System.out.println("Total Invoice Amount: " + totalAmount + " INR");
    }
}
