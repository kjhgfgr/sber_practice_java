import java.nio.file.Paths;

public class PwdCommand implements Command {
    @Override
    public void execute() {
        String pwd = Paths.get("").toAbsolutePath().toString();
        System.out.println(pwd);
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
