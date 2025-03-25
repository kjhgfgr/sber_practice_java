import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shell {
    private final Map<String, Command> commandMap = new HashMap<>();
    private boolean running = true;

    public Shell() {
        registerCommand(new DateCommand());
        registerCommand(new TimeCommand());
        registerCommand(new PwdCommand());
        registerCommand(new ExitCommand(this));
        registerCommand(new HelpCommand(commandMap));
    }


    private void registerCommand(Command command) {
        commandMap.put(command.getName(), command);
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
