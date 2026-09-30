import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    record Transaction(LocalDate date, double amount) {}

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
            new Transaction(LocalDate.of(2026, 9, 30), 150.50),
            new Transaction(LocalDate.of(2026, 9, 28), 40.00),
            new Transaction(LocalDate.of(2026, 9, 29), 200.00),
            new Transaction(LocalDate.of(2026, 9, 30), 50.25),
            new Transaction(LocalDate.of(2026, 9, 28), 65.00),
            new Transaction(LocalDate.of(2026, 9, 29), 75.50)
        );

        Map<LocalDate, Double> dailyTotals = transactions.stream()
            .collect(Collectors.groupingBy(
                Transaction::date,
                TreeMap::new,                                   
                Collectors.summingDouble(Transaction::amount)   
            ));

        dailyTotals.forEach((date, total) ->
            System.out.printf("%s -> $%.2f%n", date, total)
        );
    }
}