import java.nio.file.Files;
import java.nio.file.Paths; // путь
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileAnalyzer {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        Map<String, Integer> wordCount = new HashMap<>();

        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (String line : lines) {
            line = line.replaceAll("[^a-zA-Zа-яА-Я0-9 ]+", "").toLowerCase();
            String[] words = line.split("\\s+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        System.out.println("Частота слов в файле:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}
// C:\Users\User\Desktop\Сбертех\File.txt