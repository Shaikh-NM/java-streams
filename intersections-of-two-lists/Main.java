public class Main{
    public static void main(String[] args){
        List<Integer> list1 = List.of(1, 2, 3, 4);
        List<Integer> list2 = List.of(3, 4, 5, 6);

        List<Integer> intersections = list1.stream()
        .filter(ele -> list2.contains(ele))
        .toList();

        intersections.stream()
        .forEach(ele -> System.out.println(ele));
    }
}