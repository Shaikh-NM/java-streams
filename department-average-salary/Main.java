import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private final String department;
    private final double salary;

    public Employee(String department, double salary) {
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Engineering", 120000.0),
            new Employee("Engineering", 140000.0),
            new Employee("HR", 75000.0),
            new Employee("HR", 85000.0),
            new Employee("Sales", 95000.0)
        );

        Map<String, Double> departmentAverageSalary = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));

        departmentAverageSalary.forEach((dept, avgSalary) ->
            System.out.printf("%s -> $%.2f%n", dept, avgSalary)
        );
    }
}