public interface Command {
    void execute();

    default void exec(String[] args) throws CommandExecutionException {
        execute();
    }

    String getName();
    String getDescription();
}