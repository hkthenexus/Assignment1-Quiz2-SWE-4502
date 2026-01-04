final class CryptoPayment implements PaymentStrategy {
    private final String wallet;
    CryptoPayment(String wallet) { this.wallet = wallet; }
    @Override public void pay(double amount) {
        System.out.printf("[PAY] Charged $%.2f in crypto from wallet (%s)%n", amount, wallet);
    }
}
