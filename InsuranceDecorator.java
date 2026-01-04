final class InsuranceDecorator extends OrderDecorator {
    private final double rate; // e.g., 2%
    InsuranceDecorator(Order wrapped, double rate) {
        super(wrapped);
        this.rate = rate;
    }
    InsuranceDecorator(Order wrapped) { this(wrapped, 0.02); }

    @Override public String description() { return wrapped.description() + " + Shipping insurance"; }
    @Override public double subtotal() {
        double base = wrapped.subtotal();
        return base + (base * rate);
    }
}
