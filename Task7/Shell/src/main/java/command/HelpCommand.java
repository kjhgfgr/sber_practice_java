package command;

import java.util.Map;

public class HelpCommand implements Command {
    private final Map<String, Command> commandMap;
    private String commandName;

    public HelpCommand(Map<String, Command> commandMap) {
        this.commandMap = commandMap;
    }

    public void setInput(String input) {
        this.commandName = input;
    }

    @Override
    public void execute() {
        try {
            if (commandName != null && !commandName.isEmpty()) {
                Command command = commandMap.get(commandName);
                if (command != null) {
                    System.out.println("  " + command.getDescription());
                } else {
                    System.err.println("Ошибка: неизвестная команда " + commandName);
                }
            } else {
                System.out.println("Доступные команды:");
                for (Command command : commandMap.values()) {
                    System.out.println(" " + command.getDescription());
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "help - выводит список доступных команд";
    }
}