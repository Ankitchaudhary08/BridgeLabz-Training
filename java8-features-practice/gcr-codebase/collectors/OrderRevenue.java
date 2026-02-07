import java.util.*;
import java.util.stream.*;

class Order {
    String customer;
    double amount;

    Order(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    String getCustomer() { return customer; }
    double getAmount() { return amount; }
}

public class OrderRevenue {
    public static void main(String[] args) {
        List<Order> orders = List.of(
            new Order("Rahul", 500),
            new Order("Aman", 300),
            new Order("Rahul", 700)
        );

        Map<String, Double> revenue =
            orders.stream()
                  .collect(Collectors.groupingBy(
                      Order::getCustomer,
                      Collectors.summingDouble(Order::getAmount)
                  ));

        System.out.println(revenue);
    }
}
