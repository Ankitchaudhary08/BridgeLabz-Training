package DigitalWalletSystem;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("U1", "Ankit");
        User user2 = new User("U2", "Rahul");

        user1.getWallet().addMoney(1000);

        TransferService transferService = new WalletTransfer();

        try {
            transferService.transfer(
                    user1.getWallet(),
                    user2.getWallet(),
                    500
            );
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Ankit Balance: ₹" + user1.getWallet().getBalance());
        System.out.println("Rahul Balance: ₹" + user2.getWallet().getBalance());
    }
}
