public class Main{
    record Employee(int id, String name, String department, double salary){};
    record DepartmentSummary(Optional<Employee> maxSalaryEmployee, double averageSalary){}
    record LogEntry(long timestamp, String message, String status) {}
    
    public static void main(String[] args){
        

        // List<LogEntry> logs = List.of(
        //     new LogEntry(100, "Routine heartbeat", "OK"),
        //     new LogEntry(101, "High traffic detected", "WARN"),
        //     new LogEntry(102, "Database outage begins", "INCIDENT_START"),
        //     new LogEntry(103, "Connection pool exhausted", "ERROR"),
        //     new LogEntry(104, "Read timeouts spiking", "ERROR"),
        //     new LogEntry(105, "Replica failover complete", "INCIDENT_RESOLVED"),
        //     new LogEntry(106, "Traffic recovering", "OK")
        // );

        // List<LogEntry> res = logs.stream()
        // .dropWhile(log -> !"INCIDENT_START".equals(log.status()))
        // .skip(1)
        // .takeWhile(logs !"INCIDENT_RESOLVED".equals(log.status()))
        // .toList();


        // List<Server> servers = List.of(
        //     new Server("srv-1", "us-east", 0.01, 120.0),
        //     new Server("srv-2", "us-east", 0.08, 250.0), // Critical (errorRate > 0.05)
        //     new Server("srv-3", "eu-central", 0.02, 620.0), // Critical (p99 > 500)
        //     new Server("srv-4", "ap-south", 0.01, 95.0)
        // ); 

        // Map<Boolean, DoubleSummaryStatistics> res = servers.stream()
        // .collect(
        //     Collectors.partitioningBy(
        //         server -> server.errorRate() >= 0.05 || server.p99LatencyMs() >= 500.0,
        //         Collectors.summarizingDouble(Server::p99LatencyMs)
        //     )
        // );


        // int[] nums = {4, 9, 2, 7, 5};

        // if (nums == null || nums.length < 2) return new int[0];

        // int[] res = IntStream.range(0, nums.length-1)
        // .map(i -> Math.abs(nums[i]-nums[i+1]))
        // .toArray();

        // Arrays.stream(res)
        // .forEach(System.out::println);

        // List<Employee> employees = List.of(
        //     new Employee(1, "Alice", "IT", 90000),
        //     new Employee(2, "Bob", "IT", 120000),
        //     new Employee(3, "Charlie", "HR", 70000),
        //     new Employee(4, "Diana", "HR", 80000)
        // );

        // Map<String, DepartmentSummary> res = employees.stream(employees)
        // .collect(
        //     Collectors.groupingBy(
        //         employee -> employee.department(),
        //         Collectors.teeing(
        //             Collectors.maxBy(Comparator.comparingDouble(employee -> employee.salary())),
        //             Collectors.averagingDouble(employee -> employee.salary()),
        //             (maxSalary, averageSalary) -> new DepartmentSummary(maxSalary.orElse(null), averageSalary)
        //         )
        //     )
        // )

        // List<String> sentences = List.of(
        //     "java streams are powerful",
        //     "java streams are easy",
        //     "streams are powerful"
        // );

        // Map<Long, List<String>> = sentences.stream()
        // .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
        // .collect(
        //     Collectors.groupingBy(
        //         Function.identity(),
        //         Collectors.counting
        //     )
        // )
        // .entrySet()
        // .stream()
        // .collect(
        //     Collectors.groupingBy(
        //         entry -> entry.getValue(),
                
        //         Collectors.mapping(
        //             entry -> entry.getKey(),
        //             Collectors.groupingAndThen(
        //                 Collectors.toList(),
        //                 list -> {
        //                     Collections.sort(list);
        //                     return list;
        //                 }
        //             )
        //         )
        //     )
        // );

        // .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
        // .collect(
        //     Collectors.groupingBy(
        //         Function.identity(),
        //         Collectors.counting()
        //     )
        // )
        // .entrySet()
        // .stream()
        // .collect(
        //     Collectors.groupingBy(
        //         Map.Entry::getValue,
                
        //         Collectors.mapping(
        //             Map.Entry::getKey,
        //             Collectors.groupingAndThen(
        //                 Collectors.toList(),
        //                 list -> {
        //                     Collections.sort(list);
        //                     return list;
        //                 }
        //             )
        //         )
        //     )
        // );
    }
}


/*
    String s = "abcdbcd";

    Optional<Character> = s.chars()
    .mapToObj(c -> char(ch))
    .collect(
        Collectors.groupingBy(
            Function.identity(),
            LinkedHashMap::new,
            Collectors.counting()
        )
    )
    .entrySet()
    .stream()
    .filter(entry -> entry.getValue() == 1)
    .map(Map.Entry::getKey)
    .findFirst();
*/