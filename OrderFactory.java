import java.util.List;
import java.util.Map;

final class OrderFactory {

    enum OrderType { PHYSICAL, DIGITAL }
    enum PaymentType { CARD, PAYPAL, CRYPTO }
    enum Option { GIFT_WRAP, INSURANCE, EXPRESS_SHIPPING }

    static PaymentStrategy createPayment(PaymentType type, Map<String, String> meta) {
        switch (type) {
            case CARD -> {
                return new CreditCardPayment(meta.getOrDefault("last4", "0000"));
            }
            case PAYPAL -> {
                return new PayPalPayment(meta.getOrDefault("email", "unknown@example.com"));
            }
            case CRYPTO -> {
                return new CryptoPayment(meta.getOrDefault("wallet", "0x..."));
            }
        }
        throw new IllegalArgumentException("Unknown payment type");
    }

    static Order applyDecorators(Order order, List<Option> options) {
        if (options.contains(Option.GIFT_WRAP)) {
            order = new GiftWrapDecorator(order);
        }
        if (options.contains(Option.INSURANCE)) {
            order = new InsuranceDecorator(order);
        }
        if (options.contains(Option.EXPRESS_SHIPPING)) {
            order = new ExpressShippingDecorator(order);
        }
        return order;
    }

    static final class OrderBundle {
        final Order order;
        final OrderProcessor processor;
        OrderBundle(Order order, OrderProcessor processor) {
            this.order = order;
            this.processor = processor;
        }
    }

    static OrderBundle create(
            String orderId,
            OrderType orderType,
            List<LineItem> items,
            PaymentType paymentType,
            Map<String, String> paymentMeta,
            List<Option> options
    ) {
        PaymentStrategy payment = createPayment(paymentType, paymentMeta);

        Order base;
        OrderProcessor processor;

        switch (orderType) {
            case PHYSICAL -> {
                base = new PhysicalOrder(orderId, payment, items);
                processor = new PhysicalOrderProcessor();
            }
            case DIGITAL -> {
                base = new DigitalOrder(orderId, payment, items);
                processor = new DigitalOrderProcessor();
            }
            default -> throw new IllegalArgumentException("Unknown order type");
        }

        Order finalOrder = applyDecorators(base, options);
        return new OrderBundle(finalOrder, processor);
    }

    private OrderFactory() {}
}
