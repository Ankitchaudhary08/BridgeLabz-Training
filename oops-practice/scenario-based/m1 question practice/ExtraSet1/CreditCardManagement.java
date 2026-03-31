import java.util.*;

public class CreditCardManagement {

    static class Transaction {
        String type;
        int amount, remainingLimit;

        Transaction(String type, int amount, int remainingLimit) {
            this.type = type;
            this.amount = amount;
            this.remainingLimit = remainingLimit;
        }
    }

    static class CreditCard {
        String cardNumber, cardHolderName;
        int creditLimit, availableLimit;
        List<Transaction> transactions = new ArrayList<>();

        CreditCard(String cardNumber, String cardHolderName, int creditLimit) {
            this.cardNumber = cardNumber;
            this.cardHolderName = cardHolderName;
            this.creditLimit = creditLimit;
            this.availableLimit = creditLimit;
        }
    }

    static Map<String, CreditCard> cards = new HashMap<>();

    static void issueCard(String cardNumber, String holderName, int creditLimit) {
        if (!cards.containsKey(cardNumber)) {
            cards.put(cardNumber, new CreditCard(cardNumber, holderName, creditLimit));
        }
    }

    static void spendAmount(String cardNumber, int amount) {
        if (!cards.containsKey(cardNumber) || cards.get(cardNumber).availableLimit < amount) {
            System.out.println("Transaction declined");
            return;
        }
        CreditCard card = cards.get(cardNumber);
        card.availableLimit -= amount;
        card.transactions.add(new Transaction("SPEND", amount, card.availableLimit));
        System.out.println("SPENT " + cardNumber + " " + card.availableLimit);
    }

    static void makePayment(String cardNumber, int amount) {
        if (!cards.containsKey(cardNumber)) {
            System.out.println("Card not found");
            return;
        }
        CreditCard card = cards.get(cardNumber);
        card.availableLimit = Math.min(card.availableLimit + amount, card.creditLimit);
        card.transactions.add(new Transaction("PAYMENT", amount, card.availableLimit));
        System.out.println("PAYMENT DONE " + cardNumber + " " + card.availableLimit);
    }

    static void getCardsByHolder(String holderName) {
        List<CreditCard> result = new ArrayList<>();
        for (CreditCard card : cards.values()) {
            if (card.cardHolderName.equals(holderName)) result.add(card);
        }
        if (result.isEmpty()) {
            System.out.println("No cards found");
            return;
        }
        result.sort(Comparator.comparing(c -> c.cardNumber));
        for (CreditCard c : result) {
            System.out.println(c.cardNumber + " " + c.availableLimit);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            // Handle spaces in cardNumber (e.g., "C103 Alice 7 000" → "7000")
            String[] parts = line.split("\\s+");
            String cmd = parts[0];

            if (cmd.equals("ISSUE")) {
                String cardNum = parts[1];
                String holderName = parts[2];
                // creditLimit could have spaces like "7 000" → join remaining parts
                String limitStr = String.join("", Arrays.copyOfRange(parts, 3, parts.length));
                int limit = Integer.parseInt(limitStr);
                issueCard(cardNum, holderName, limit);
            } else if (cmd.equals("SPEND")) {
                String cardNum = parts[1];
                String amtStr = String.join("", Arrays.copyOfRange(parts, 2, parts.length));
                int amt = Integer.parseInt(amtStr);
                spendAmount(cardNum, amt);
            } else if (cmd.equals("PAYMENT")) {
                String cardNum = parts[1];
                int amt = Integer.parseInt(parts[2]);
                makePayment(cardNum, amt);
            } else if (cmd.equals("HOLDER")) {
                String holderName = parts[1];
                getCardsByHolder(holderName);
            }
        }
        sc.close();
    }
}
