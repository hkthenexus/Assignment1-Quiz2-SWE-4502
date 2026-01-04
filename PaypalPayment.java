final class PayPalPayment implements PaymentStrategy {
    private final String email;
    PayPalPayment(String email) { this.email = email; }
    @Override public void pay(double amount) {
        System.out.printf("[PAY] Charged $%.2f to PayPal account (%s)%n", amount, email);
    }
}