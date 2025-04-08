package command;

public class ExitCommand implements Command {
    private final Shell shell;

    public ExitCommand(Shell shell) {
        this.shell = shell;
    }

    @Override
    public void execute() {
        shell.exit();
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "exit - завершает работу приложения";
    }
}