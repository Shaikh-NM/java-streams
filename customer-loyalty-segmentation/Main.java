
public class CustomerLoyaltySegmentation {

    public static LoyaltyTier determineTier(BigDecimal spend) {
        if (spend.compareTo(new BigDecimal("1000.00")) >= 0) {
            return LoyaltyTier.PLATINUM;
        } else if (spend.compareTo(new BigDecimal("500.00")) >= 0) {
            return LoyaltyTier.GOLD;
        } else {
            return LoyaltyTier.SILVER;
        }
    }

    public static Map<LoyaltyTier, List<CustomerSpend>> getTopSpendersByTier(
        List<CustomerOrder> orders,
        int k
    ) {
        return orders.stream()
            .filter(order -> order.status() == OrderStatus.DELIVERED)

            .collect(Collectors.groupingBy(
                CustomerOrder::customerId,
                Collectors.reducing(
                    BigDecimal.ZERO,
                    order -> order.items().stream()
                        .map(item -> item.unitPrice().multiply(BigDecimal.valueOf(item.quantity())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add),
                    BigDecimal::add
                )
            ))

            .entrySet()
            .stream()
            .map(entry -> new CustomerSpend(entry.getKey(), entry.getValue()))
            .collect(Collectors.groupingBy(
                cs -> determineTier(cs.totalSpend()),
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> list.stream()
                        .sorted(Comparator.comparing(CustomerSpend::totalSpend).reversed())
                        .limit(k)
                        .toList()
                )
            ));
    }

    public static void main(String[] args) {
        List<CustomerOrder> orders = List.of(
            new CustomerOrder("O1", "C1", OrderStatus.DELIVERED, List.of(
                new OrderItem("I1", 2, new BigDecimal("600.00")) 
            )),
            new CustomerOrder("O2", "C2", OrderStatus.DELIVERED, List.of(
                new OrderItem("I2", 1, new BigDecimal("750.00")) 
            )),
            new CustomerOrder("O3", "C3", OrderStatus.DELIVERED, List.of(
                new OrderItem("I3", 1, new BigDecimal("200.00")) 
            )),
            new CustomerOrder("O4", "C4", OrderStatus.CANCELLED, List.of(
                new OrderItem("I4", 5, new BigDecimal("500.00")) 
            )),
            new CustomerOrder("O5", "C2", OrderStatus.DELIVERED, List.of(
                new OrderItem("I5", 1, new BigDecimal("350.00")) 
            )),
            new CustomerOrder("O6", "C5", OrderStatus.DELIVERED, List.of(
                new OrderItem("I6", 3, new BigDecimal("200.00")) 
            ))
        );

        Map<LoyaltyTier, List<CustomerSpend>> result = getTopSpendersByTier(orders, 2);

        result.forEach((tier, spenders) -> {
            System.out.println(tier + " -> " + spenders);
        });
    }
}