import java.util.HashMap;
import java.util.Map;

public class Shell {
    private final Map<String, Command> commandMap = new HashMap<>();
    private boolean running = true;

    public void registerCommand(Command command) {
        commandMap.put(command.getName(), command);
    }

    public void executeCommand(String input) {
        String[] parts = input.split(" ", 2);
        String commandName = parts[0];
        Command command = commandMap.get(commandName);

        if (command != null) {
            if (command instanceof HelpCommand && parts.length > 1) {
                ((HelpCommand) command).setInput(parts[1]);
            }
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

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }
}