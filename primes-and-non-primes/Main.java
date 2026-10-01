public class Main{
    private static boolean isPrime(int num){
        if (n <= 1){
            return false;
        }
        return IntStream.rangeClosed(2, (int)Math.sqrt(num))
        .noneMatch(d -> n%d == 0);
    }

    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
        .collect(Collectors.partitioningBy(num -> isPrime(num)));
    }
}