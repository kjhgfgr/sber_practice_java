@Info(
        name = "exit",
        description = "Завершает работу приложения"
)
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
    public void exec(String[] args) throws Error {
        shell.exit();
    }

    @Override
    public String getName() {
        Info info = this.getClass().getAnnotation(Info.class);
        return info != null ? info.name() : "exit";
    }

    @Override
    public String getDescription() {
        Info info = this.getClass().getAnnotation(Info.class);
        return info != null ? info.description() : "завершает работу приложения";
    }
}