import java.util.Objects;

abstract class OrderDecorator implements Order {
    protected final Order wrapped;

    protected OrderDecorator(Order wrapped) {
        this.wrapped = Objects.requireNonNull(wrapped);
    }

    @Override public String getOrderId() { return wrapped.getOrderId(); }
    @Override public PaymentStrategy payment() { return wrapped.payment(); }
    @Override public String description() { return wrapped.description(); }
    @Override public double subtotal() { return wrapped.subtotal(); }
}

