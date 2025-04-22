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
                    System.out.println("  " + getFullDescription(command));
                } else {
                    System.err.println("Ошибка: неизвестная команда " + commandName);
                }
            } else {
                System.out.println("Доступные команды:");
                commandMap.values().forEach(cmd -> {
                    System.out.println("  " + getFullDescription(cmd));
                });
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private String getFullDescription(Command command) {
        Info info = command.getClass().getAnnotation(Info.class);
        if (info != null) {
            return info.name() + " - " + info.description();
        }
        return command.getName() + " - " + command.getDescription();
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "выводит список команд";
    }
}