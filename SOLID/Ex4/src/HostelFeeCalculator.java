import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final List<PricingComponent> components;

    public HostelFeeCalculator(FakeBookingRepo repo) { 
        this.repo = repo; 
        this.components = new ArrayList<>();
        this.components.add(new RoomPricingComponent());
        this.components.add(new AddOnPricingComponent());
    }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        double total = 0.0;
        for(PricingComponent comp : components) {
            total += comp.getFee(req);
        }
        return new Money(total);
    }
}
