abstract class OrderProcessor {

    public final void process(Order order) {
        System.out.printf("%n=== Processing order %s ===%n", order.getOrderId());
        validateOrder(order);
        double total = calculateTotal(order);
        total = applyDiscounts(order, total);
        takePayment(order, total);
        shipOrFulfill(order);
        notifyCustomer(order, total);
        System.out.println("=== Done ===\n");
    }

    protected void validateOrder(Order order) {
        if (order.subtotal() <= 0) throw new IllegalStateException("Order subtotal must be positive.");
        System.out.printf("[OK] Validated: %s (subtotal=$%.2f)%n", order.description(), order.subtotal());
    }

    protected double calculateTotal(Order order) {
        double total = order.subtotal();
        System.out.printf("[CALC] Total before discounts: $%.2f%n", total);
        return total;
    }

    //hook method
    protected double applyDiscounts(Order order, double total) {
        System.out.println("[DISC] No discounts applied");
        return total;
    }

    protected void takePayment(Order order, double total) {
        System.out.println("[PAY] Taking payment...");
        order.payment().pay(total); 
    }

    protected abstract void shipOrFulfill(Order order);

    protected void notifyCustomer(Order order, double total) {
        System.out.printf("[NOTE] Customer notified: charged $%.2f%n", total);
    }
}

