import java.util.Map;

public class ConsoleReport implements Report {
    @Override
    public void generateReport(Map<String, Integer> words) {
        System.out.println("Общая статистика по всем файлам:");
        words.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(20)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}