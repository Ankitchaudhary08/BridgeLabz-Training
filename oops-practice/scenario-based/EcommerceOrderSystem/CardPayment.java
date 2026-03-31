public class CardPayment implements Payment {

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount <= 0) {
            throw new PaymentFailedException("Card payment failed");
        }
        System.out.println("Card payment successful: ₹" + amount);
    }
}
