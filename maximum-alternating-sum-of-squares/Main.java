public class Main{
    public static void main(String[] args){
        int[] nums = Array.of(1,-1,2,-2,3,-3);
        int n = nums.length;

        long[] sortedSquares = Array.stream(nums)
        .mapToLong(num -> (long)num*num)
        .sorted()
        .toArray();

        int mid = n/2;

        long negativeSum = sortedSquares.stream()
        .limit(mid)
        .sum();

        long positiveSum = sortedSquares.stream()
        .skip(mid)
        .sum();

        long res = positiveSum-negativeSum;
        System.out.println(res);
    }
}