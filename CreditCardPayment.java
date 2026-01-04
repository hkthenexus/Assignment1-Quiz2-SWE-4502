final class CreditCardPayment implements PaymentStrategy {
    private final String last4;
    CreditCardPayment(String last4) { this.last4 = last4; }
    @Override public void pay(double amount) {
        System.out.printf("[PAY] Charged $%.2f to credit card ****%s%n", amount, last4);
    }
}
