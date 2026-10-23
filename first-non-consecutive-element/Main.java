import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Main {

    public static Optional<Integer> findFirstBreak(List<Integer> list) {
        if (list == null || list.size() < 2) {
            return Optional.empty();
        }

        return IntStream.range(1, list.size())
                .filter(i -> list.get(i) != list.get(i - 1) + 1)
                .mapToObj(list::get)
                .findFirst();
    }

    public static void main(String[] args) {
        System.out.println(findFirstBreak(List.of(1, 2, 3, 5, 6, 8))); 
        System.out.println(findFirstBreak(List.of(10, 11, 12, 13)));    
        System.out.println(findFirstBreak(List.of(42)));               
    }
}