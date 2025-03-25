import java.util.Map;
public class HelpCommand implements Command {
    private final Map<String, Command> commandMap;

    public HelpCommand(Map<String, Command> commandMap) {
        this.commandMap = commandMap;
    }

    @Override
    public void execute() {
        for (Command command : commandMap.values()) {
            System.out.println(command.getDescription());
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
