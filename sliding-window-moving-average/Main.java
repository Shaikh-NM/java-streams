public class Main{
    public record MetricEvent(long timestamp, double value){}

    public static void main(String[] args){
        List<MetricEvent> events = List.of(
            new MetricEvent(1001, 10.0),
            new MetricEvent(1002, 20.0),
            new MetricEvent(1003, 30.0),
            new MetricEvent(1004, 40.0),
            new MetricEvent(1005, 50.0)
        );

        int windowSize = 3;

        double initialSum = events.stream()
        .limit(windowSize)
        .mapToDouble(MetricEvent::value)
        .sum();

        return IntStream.range(0, n-windowSize+1)
        .mapToDouble(i -> events.subList(i, i+windowSize))
        .stream()
        .mapToDouble(MetricEvent::value)
        .average()
        .orElse(0.0)
        .boxed()
        .toList();
    }
}