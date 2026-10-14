public class Main{
    public static void main(String[] args){
        List<String> documents = List.of(
            "Apache Kafka is a distributed event store and stream-processing platform.",
            "Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications.",
            "Kafka is commonly used for event-driven microservices architectures.",
            "Redis provides in-memory data storage, caching, and pub/sub messaging.",
            "Distributed systems leverage Kafka and Redis for high-throughput stream processing."
        );

        ConcurrentMap<String, Long> wordCounts = documents.parallelStream()
        .flatMap(doc -> Arrays.stream(doc.toLowerCase().split("\\W+")))
        .filter(token -> !token.isBlank())
        .collect(
            Collectors.groupingByConcurrent(
                token -> token,
                Collectors.counting()
            )
        );

        wordCounts.entrySet().stream()
            .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
            .forEach(entry -> System.out.printf("%-18s : %d%n", entry.getKey(), entry.getValue()));
    }
}