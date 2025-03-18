public class ExitCommand implements Command {
    private final Shell shell;

    public ExitCommand(Shell shell) {
        this.shell = shell;
    }

    @Override
    public void execute() {
        shell.exit();
    }
}
