public class Main{
    public record LogEntry(
        String serverId,
        String level,
        String errorCode,
        long timestampMs
    ) {}

    public static void main(String[] args){
        List<LogEntry> logs = List.of(
            new LogAnalyzer.LogEntry("srv-01", "ERROR", "ERR_503", 1700000001000L),
            new LogAnalyzer.LogEntry("srv-02", "error", "ERR_503", 1700000002000L), // case-insensitive check
            new LogAnalyzer.LogEntry("srv-01", "ERROR", "ERR_DB_TIMEOUT", 1700000003000L),
            new LogAnalyzer.LogEntry("srv-03", "ERROR", "ERR_AUTH_FAIL", 1700000004000L),
            new LogAnalyzer.LogEntry("srv-04", "ERROR", "ERR_503", 1700000005000L),
            new LogAnalyzer.LogEntry("srv-02", "ERROR", "ERR_DB_TIMEOUT", 1700000006000L),
            new LogAnalyzer.LogEntry("srv-03", "ERROR", "ERR_AUTH_FAIL", 1700000007000L),
            new LogAnalyzer.LogEntry("srv-05", "ERROR", "ERR_503", 1700000008000L),
            new LogAnalyzer.LogEntry("srv-01", "ERROR", "ERR_AUTH_FAIL", 1700000009000L),
            new LogAnalyzer.LogEntry("srv-02", "ERROR", "ERR_DB_TIMEOUT", 1700000010000L),
            new LogAnalyzer.LogEntry("srv-04", "ERROR", "ERR_NETWORK", 1700000011000L),

            new LogAnalyzer.LogEntry("srv-01", "INFO", "OK_200", 1700000012000L),
            new LogAnalyzer.LogEntry("srv-02", "WARN", "WARN_DEPRECATED", 1700000013000L),
            new LogAnalyzer.LogEntry("srv-03", "ERROR", null, 1700000014000L),           // null code
            new LogAnalyzer.LogEntry("srv-04", "ERROR", "   ", 1700000015000L),         // blank code
            new LogAnalyzer.LogEntry("srv-05", "DEBUG", "DBG_TRACE", 1700000016000L)
        );

        int k = 5;

        if (logs == null || logs.isEmpty() || k <= 0){
            return List.of();
        }

        ConcurrentMap<String, Long> errorCounts = logs.parallelStream()
        .filter(
            entry -> entry != null,
            && "ERROR".equalsIgnoreCase(entry.level)
            && entry.errorCode() != null
            && !entry.errorCode().isBlank()
        )
        .collect(
            Collectors.groupingByConcurrent(
                LogEntry::errorCode,
                Collectors.counting()
            )
        );

        return errorCounts.entrySet()
        .stream()
        .sorted(
            Map.Entry.<String, Long> comparingByValue(Comparator.reverseOrder())
            .thenComparing(Map.Entry.comparingByKey())
        )
        .limit(k)
        .toList();
    }
}