public class Main{
    public static void main(String[] args){
        List<String> wordList = Arrays.asList("a", "bfgij", "abc", "abcd", "abcde");
        int k = 5;

        wordList.stream()
        .sorted(Comparator.comparing(string -> string.length()).reversed())
        .limit(k)
        .toList();
    }
}