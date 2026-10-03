public class Main{
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 3, 2, 2, 4, 4, 4, 8, 3, 1, 2, 1, 2};
        int k = 3;

        int[] res = Arrays.stream(nums)
        .boxed()
        .collect(
            Collectors.groupingBy(
                Function.identity(), Collectors.counting()
            )
        )
        .entrySet()
        .stream()   
        .sorted(Map.Entry.<Integer, Long> comparingByValue().reversed())
        .limit(k)
        .mapToInt(Map.Entry::getKey)
        .toArray();

        Arrays.stream(res)
        .forEach(System.out::println);
    }
}