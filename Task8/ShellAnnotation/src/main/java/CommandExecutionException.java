public class CommandExecutionException extends Exception {
    private final String commandName;

    public CommandExecutionException(String commandName, String message) {
        super(message);
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}