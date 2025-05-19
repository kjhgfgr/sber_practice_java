import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class FileAnalyzerTwo {
    private final Path path;
    private final Report report;
    private final ExecutorService executor;
    private final ConcurrentMap<String, Integer> globalWordCount = new ConcurrentHashMap<>();

    public FileAnalyzerTwo(Path path, Report report, int threadCount) {
        this.path = path;
        this.report = report;
        this.executor = Executors.newFixedThreadPool(threadCount);
    }

    public void analyzeDirectory(String dirPath) throws IOException, InterruptedException {
        List<Future<?>> futures = new ArrayList<>();

        Files.walk(Paths.get(dirPath))
                .filter(Files::isRegularFile)
                .filter(p -> p.toString().endsWith(".txt"))
                .forEach(p -> {
                    futures.add(executor.submit(() -> {
                        try {
                            processFile(p.toString());
                        } catch (IOException e) {
                            System.err.println("Ошибка при обработке файла " + p + ": " + e.getMessage());
                        }
                    }));
                });

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (ExecutionException e) {
                System.err.println("Ошибка при выполнении задачи: " + e.getCause().getMessage());
            }
        }

        executor.shutdown();
        report.generateReport(globalWordCount);
    }

    private void processFile(String filePath) throws IOException {
        Map<String, Integer> wordCount = new HashMap<>();
        List<String> lines = path.readFile(filePath);

        for (String line : lines) {
            line = line.replaceAll("[^a-zA-Zа-яА-Я0-9 ]+", "").toLowerCase();
            String[] words = line.split("\\s+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        wordCount.forEach((word, count) ->
                globalWordCount.merge(word, count, Integer::sum));

        System.out.println("Обработан файл: " + filePath);
    }

    public static void main(String[] args) {

        String dirPath = args[0];
        int threadCount = Integer.parseInt(args[1]);

        FileAnalyzerTwo analyzer = new FileAnalyzerTwo(new ConsolePath(), new ConsoleReport(), threadCount);

        try {
            long startTime = System.currentTimeMillis();
            analyzer.analyzeDirectory(dirPath);
            long endTime = System.currentTimeMillis();
            System.out.println("Время выполнения: " + (endTime - startTime) + " мс");
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}