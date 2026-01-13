package DigitalWalletSystem;

public class User {
    private String userId;
    private String name;
    private Wallet wallet;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.wallet = new Wallet(userId);
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getName() {
        return name;
    }
}
