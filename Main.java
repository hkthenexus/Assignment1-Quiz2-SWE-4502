import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<LineItem> items1 = List.of(
                new LineItem("SHOE-1", "Running Shoes", 80.00, 1),
                new LineItem("SOCK-2", "Socks (3-pack)", 12.50, 2)
        );

        Map<String, String> cardMeta = Map.of("last4", "4242");

        OrderFactory.OrderBundle bundle1 = OrderFactory.create(
                "A1001",
                OrderFactory.OrderType.PHYSICAL,
                items1,
                OrderFactory.PaymentType.CARD,
                cardMeta,
                List.of(
                        OrderFactory.Option.GIFT_WRAP,
                        OrderFactory.Option.INSURANCE,
                        OrderFactory.Option.EXPRESS_SHIPPING
                )
        );

        bundle1.processor.process(bundle1.order);

        List<LineItem> items2 = List.of(
                new LineItem("EBOOK-9", "E-book Bundle", 30.00, 1)
        );

        Map<String, String> ppMeta = Map.of("email", "buyer@example.com");

        OrderFactory.OrderBundle bundle2 = OrderFactory.create(
                "D2007",
                OrderFactory.OrderType.DIGITAL,
                items2,
                OrderFactory.PaymentType.PAYPAL,
                ppMeta,
                List.of(OrderFactory.Option.INSURANCE) // just to show decorator
        );

        bundle2.processor.process(bundle2.order);
    }
}