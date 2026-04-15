import java.util.*;

public class RoomPricingComponent implements PricingComponent {
    private final Map<Integer, Double> rates = new HashMap<>();

    public RoomPricingComponent() {
        rates.put(LegacyRoomTypes.SINGLE, 14000.0);
        rates.put(LegacyRoomTypes.DOUBLE, 15000.0);
        rates.put(LegacyRoomTypes.TRIPLE, 12000.0);
        rates.put(LegacyRoomTypes.DELUXE, 16000.0);
    }

    public void addRate(int type, double rate) {
        rates.put(type, rate);
    }

    @Override
    public double getFee(BookingRequest req) {
        return rates.getOrDefault(req.roomType, 16000.0);
    }
}
