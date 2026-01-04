final class DigitalOrderProcessor extends OrderProcessor {
    @Override protected double applyDiscounts(Order order, double total) {
        total *= 0.95;
        System.out.println("[DISC] Digital discount applied: -5%");
        System.out.printf("[CALC] Total after discounts: $%.2f%n", total);
        return total;
    }

    @Override protected void shipOrFulfill(Order order) {
        System.out.println("[FULFILL] Emailing download links / license keys...");
    }
}