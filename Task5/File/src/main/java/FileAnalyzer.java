import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Path {
    List<String> readFile(String path) throws IOException;
}

interface Report {
    void generateReport(Map<String, Integer> words);
}

class ConsolePath implements Path {
    @Override
    public List<String> readFile(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }
}

class ConsoleReport implements Report {
    @Override
    public void generateReport(Map<String, Integer> words) {
        System.out.println("Частота слов в файле:");
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class FileAnalyzer {
    private final Path path;
    private final Report report;

    public FileAnalyzer(Path path, Report report) {
        this.path = path;
        this.report = report;
    }

    public void analyze(String filePath) throws IOException {
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
        report.generateReport(wordCount);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Укажите путь к файлу.");
            return;
        }

        String path = args[0];
        FileAnalyzer analyzer = new FileAnalyzer(new ConsolePath(), new ConsoleReport());

        try {
            analyzer.analyze(path);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}

// C:\Users\User\Desktop\Сбертех\File.txt