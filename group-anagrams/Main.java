public class Main{
    public static void main(String[] args){
        List<String> words = List.of("eat", "tea", "tan", "ate", "nat", "bat");
        words.stream()
        .collect(Collectors.groupingBy(word -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            return new String(chars); 
        }))
        .values();
    }
}