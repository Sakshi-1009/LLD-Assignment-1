import java.util.*;

public class AddOnPricingComponent implements PricingComponent {
    private final Map<AddOn, Double> rates = new HashMap<>();

    public AddOnPricingComponent() {
        rates.put(AddOn.MESS, 1000.0);
        rates.put(AddOn.LAUNDRY, 500.0);
        rates.put(AddOn.GYM, 300.0);
    }

    public void addRate(AddOn addOn, double rate) {
        rates.put(addOn, rate);
    }

    @Override
    public double getFee(BookingRequest req) {
        double add = 0.0;
        for (AddOn a : req.addOns) {
            add += rates.getOrDefault(a, 0.0);
        }
        return add;
    }
}
