import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Shell shell = new Shell();
        Analyzer analyzer = new Analyzer();
        initializeCommands(shell, analyzer);

        Scanner scanner = new Scanner(System.in);
        String input;

        while (shell.isRunning()) {
            System.out.print("> ");
            input = scanner.nextLine().trim();
            shell.executeCommand(input);
        }

        scanner.close();
    }

    private static void initializeCommands(Shell shell, Analyzer analyzer) {
        HelpCommand helpCommand = new HelpCommand(shell.getCommandMap());
        shell.registerCommand(helpCommand);

        shell.registerCommand(new DateCommand());
        shell.registerCommand(new TimeCommand());
        shell.registerCommand(new PwdCommand());
        shell.registerCommand(new ExitCommand(shell));

        Set<Class<?>> commandClasses = analyzer.findCommandClasses(Shell.class.getPackage().getName());
        for (Class<?> clazz : commandClasses) {
            try {
                if (!HelpCommand.class.isAssignableFrom(clazz)) {
                    Command command;
                    if (ExitCommand.class.isAssignableFrom(clazz)) {
                        command = (Command) clazz.getDeclaredConstructor(Shell.class).newInstance(shell);
                    } else {
                        command = (Command) clazz.getDeclaredConstructor().newInstance();
                    }
                    if (!shell.getCommandMap().containsKey(command.getName())) {
                        shell.registerCommand(command);
                    }
                }
            } catch (Exception e) {
                System.err.println("Ошибка при создании команды " + clazz.getSimpleName() + ": " + e.getMessage());
            }
        }
    }
}