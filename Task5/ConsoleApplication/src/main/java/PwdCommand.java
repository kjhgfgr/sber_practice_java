import java.nio.file.Paths;

public class PwdCommand implements Command {
    @Override
    public void execute() {
        String pwd = Paths.get("").toAbsolutePath().toString();
        System.out.println(pwd);
    }
}
