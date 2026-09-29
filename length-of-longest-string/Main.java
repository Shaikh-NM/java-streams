public class Main{
    public static void main(String[] args){
        List<String> names = Arrays.asList("Alice", "Bob", "Alexander", "Christopher", "Dan");
        int maxLength = names.stream()
        .mapToInt(name -> name.length())
        .max()
        .orElse(0)

        System.out.Println(maxLength);
    }
}