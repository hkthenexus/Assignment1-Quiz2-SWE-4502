final class LineItem {
    final String sku;
    final String name;
    final double unitPrice;
    final int qty;

    LineItem(String sku, String name, double unitPrice, int qty) {
        if (qty <= 0) throw new IllegalArgumentException("qty must be positive");
        if (unitPrice < 0) throw new IllegalArgumentException("unitPrice must be >= 0");
        this.sku = sku;
        this.name = name;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    double total() { return unitPrice * qty; }
}
