final class ExpressShippingDecorator extends OrderDecorator {
    private final double fee;
    ExpressShippingDecorator(Order wrapped, double fee) {
        super(wrapped);
        this.fee = fee;
    }
    ExpressShippingDecorator(Order wrapped) { this(wrapped, 15.00); }

    @Override public String description() { return wrapped.description() + " + Express shipping"; }
    @Override public double subtotal() { return wrapped.subtotal() + fee; }
}

