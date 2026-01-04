final class GiftWrapDecorator extends OrderDecorator {
    private final double fee;
    GiftWrapDecorator(Order wrapped, double fee) {
        super(wrapped);
        this.fee = fee;
    }
    GiftWrapDecorator(Order wrapped) { this(wrapped, 5.00); }

    @Override public String description() { return wrapped.description() + " + Gift wrap"; }
    @Override public double subtotal() { return wrapped.subtotal() + fee; }
}