import java.util.HashMap;
import java.util.Map;

public class Shell {
    private final Map<String, Command> commandMap = new HashMap<>();
    private boolean running = true;

    public void registerCommand(Command command) {
        Info info = command.getClass().getAnnotation(Info.class);
        if (info != null) {
            commandMap.put(info.name(), command);
        } else {
            commandMap.put(command.getName(), command);
        }
    }

    public void executeCommand(String input) {
        if (input == null || input.trim().isEmpty()) {
            return;
        }

        String[] parts = input.split("\\s+", 2);
        String commandName = parts[0];
        String[] args = parts.length > 1 ? new String[]{parts[1]} : new String[0];

        Command command = commandMap.get(commandName);
        if (command != null) {
            try {
                if (command instanceof HelpCommand) {
                    ((HelpCommand) command).setInput(args.length > 0 ? args[0] : "");
                }
                command.exec(args);
            } catch (CommandExecutionException e) {
                System.err.println("Ошибка выполнения команды '" + e.getCommandName() + "': " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        } else {
            System.out.println("Ошибка: неизвестная команда '" + commandName + "'");
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