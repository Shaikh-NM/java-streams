import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final Pattern NON_ALPHANUMERIC = Pattern.compile("[^a-zA-Z0-9]+");

    public record WordDocEntry(String word, int docId) {}

    public static Map<String, Map<Integer, Long>> buildIndex(List<String> documents) {
        if (documents == null || documents.isEmpty()) {
            return Map.of();
        }

        return IntStream.range(0, documents.size())
            .boxed()
            .flatMap(docId -> {
                String doc = documents.get(docId);
                if (doc == null || doc.isBlank()) {
                    return null;
                }
                return NON_ALPHANUMERIC.splitAsStream(doc)
                    .map(String::trim)
                    .filter(token -> !token.isEmpty())
                    .map(String::toLowerCase)
                    .map(word -> new WordDocEntry(word, docId));
            })
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(
                WordDocEntry::word,
                Collectors.groupingBy(
                    WordDocEntry::docId,
                    Collectors.counting()
                )
            ));
    }

    public static void main(String[] args) {
        List<String> docs = List.of(
            "Hello world, hello!",        
            "World, welcome to Java.",    
            "Java streams are powerful."  
        );

        Map<String, Map<Integer, Long>> index = buildIndex(docs);

        index.forEach((word, occurrences) -> 
            System.out.println(word + " -> " + occurrences)
        );
    }
}