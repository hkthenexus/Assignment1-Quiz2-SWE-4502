import java.util.Objects;

abstract class BaseOrder implements Order {
    private final String orderId;
    private final PaymentStrategy payment;

    BaseOrder(String orderId, PaymentStrategy payment) {
        this.orderId = Objects.requireNonNull(orderId);
        this.payment = Objects.requireNonNull(payment);
    }

    @Override public String getOrderId() { return orderId; }
    @Override public PaymentStrategy payment() { return payment; }
}