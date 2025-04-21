import java.nio.file.Paths;

public class PwdCommand implements Command {
    @Override
    public void execute() {
        try {
            String pwd = Paths.get("").toAbsolutePath().toString();
            System.out.println(pwd);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "pwd";
    }

    @Override
    public String getDescription() {
        return "pwd - выводит текущий рабочий каталог";
    }
}