public class Main{
    public static void main(String[] args){
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8, 9, 10};

        int threshold = 3;

        Stream.concat(nums1.stream(), nums2.stream())
        .boxed()
        .sorted()
        .filter(num -> num > threshold)
        .forEach(System.out::println);
    }
}