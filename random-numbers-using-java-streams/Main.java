public class Main{
    public static void main(String[] args){
        Random random = new Random();
        List<Integer> nums = Stream.generate(random::nextInt)
        .limit(10)
        .toList();
    }
}