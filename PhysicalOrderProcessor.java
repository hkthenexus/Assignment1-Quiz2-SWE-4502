final class PhysicalOrderProcessor extends OrderProcessor {
    @Override protected double applyDiscounts(Order order, double total) {
        if (total >= 100.0) {
            total -= 10.0;
            System.out.println("[DISC] Physical order promo applied: -$10.00");
        } else {
            System.out.println("[DISC] No physical promo eligible");
        }
        System.out.printf("[CALC] Total after discounts: $%.2f%n", total);
        return total;
    }

    @Override protected void shipOrFulfill(Order order) {
        System.out.println("[SHIP] Shipping physical items...");
    }
}
