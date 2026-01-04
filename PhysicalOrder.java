import java.util.List;

final class PhysicalOrder extends BaseOrder {
    private final List<LineItem> items;

    PhysicalOrder(String orderId, PaymentStrategy payment, List<LineItem> items) {
        super(orderId, payment);
        this.items = List.copyOf(items);
    }

    @Override public String description() { return "Physical goods order"; }

    @Override public double subtotal() {
        return items.stream().mapToDouble(LineItem::total).sum();
    }
}