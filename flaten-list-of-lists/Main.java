public class Main{
    public static void main(String[] args){
        List<List<String>> nestedList = Arrays.asList(
            Arrays.asList("x", "y", "z"),
            Arrays.asList("a", "b", "c"),
            Arrays.asList("1", "2", "3")
        );

        List<String> res = nestedList.stream()
        .flatMap(list -> list.stream())
        .toList();

        res.stream()
        .forEach(System.out::println);
    }
}