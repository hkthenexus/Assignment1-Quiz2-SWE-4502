interface Order {
    String getOrderId();
    String description();
    double subtotal();
    PaymentStrategy payment(); 
}
