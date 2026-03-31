package HotelRegistrationSystem;

public class SeasonalPricing implements PricingStrategy {

    @Override
    public double calculatePrice(Room room, int days) {
        double basePrice = room.getBasePrice();
        return basePrice * days * 1.2; // 20% seasonal increase
    }
}

