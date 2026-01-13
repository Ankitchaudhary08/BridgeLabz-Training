public class WalletPayment implements Payment {

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 5000) {
            throw new PaymentFailedException("Insufficient wallet balance");
        }
        System.out.println("Wallet payment successful: ₹" + amount);
    }
}
