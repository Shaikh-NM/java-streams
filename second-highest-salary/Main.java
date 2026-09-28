import java.util.*;
public class Main{
    public static void main(String[] args){
        List<Double> salaries = Arrays.asList(20000.45, 35000.54, 45000.65, 30000.99);
        Optional<Double> secondhighestsalary = salaries.stream()
        .distinct()
        .sorted(Comparator.reverseOrder())
        .skip(1)
        .findFirst();

        secondhighestsalary.ifPresent(System.out::println);
    }
}