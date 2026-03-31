public class UPIPayment implements Payment {

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 100000) {
            throw new PaymentFailedException("UPI limit exceeded");
        }
        System.out.println("UPI payment successful: ₹" + amount);
    }
}
