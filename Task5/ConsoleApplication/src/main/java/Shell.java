import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shell {
    private final Map<String, Command> commandMap = new HashMap<>();
    private boolean running = true;

    public Shell() {
        // Регистрация команд
        registerCommand("date", new DateCommand());
        registerCommand("time", new TimeCommand());
        registerCommand("pwd", new PwdCommand());
        registerCommand("exit", new ExitCommand(this));
        registerCommand("help", new HelpCommand());
    }

    private void registerCommand(String name, Command command) {
        commandMap.put(name, command);
    }

    public void executeCommand(String input) {
        Command command = commandMap.get(input);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Ошибка: неизвестная команда '" + input + "'");
        }
    }

    public void exit() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public static void main(String[] args) {
        Shell shell = new Shell();
        Scanner scanner = new Scanner(System.in);
        String input;

        while (shell.isRunning()) {
            System.out.print("> ");
            input = scanner.nextLine().trim();
            shell.executeCommand(input);
        }

        scanner.close();
    }
}
