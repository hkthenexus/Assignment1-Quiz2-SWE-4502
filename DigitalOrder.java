import java.util.List;

final class DigitalOrder extends BaseOrder {
    private final List<LineItem> items;

    DigitalOrder(String orderId, PaymentStrategy payment, List<LineItem> items) {
        super(orderId, payment);
        this.items = List.copyOf(items);
    }

    @Override public String description() { return "Digital goods order"; }

    @Override public double subtotal() {
        return items.stream().mapToDouble(LineItem::total).sum();
    }
}

