package command;

import java.lang.reflect.Modifier;
import java.util.*;
import java.io.File;
import java.net.URL;

public class Shell {
    private final Map<String, Command> commandMap = new HashMap<>();
    private boolean running = true;

    public Shell() {
        registerCommands();
    }

    private void registerCommands() {
        try {
            HelpCommand helpCommand = new HelpCommand(commandMap);
            registerCommand(helpCommand);

            Set<Class<?>> classes = getClasses(this.getClass().getPackage().getName());

            for (Class<?> clazz : classes) {
                if (Command.class.isAssignableFrom(clazz) && !clazz.isInterface() && !Modifier.isAbstract(clazz.getModifiers())) {
                    if (clazz == HelpCommand.class) continue;

                    Command command;
                    if (clazz == ExitCommand.class) {
                        command = (Command) clazz.getDeclaredConstructor(Shell.class).newInstance(this);
                    } else {
                        command = (Command) clazz.getDeclaredConstructor().newInstance();
                    }
                    registerCommand(command);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Set<Class<?>> getClasses(String packageName) {
        Set<Class<?>> classes = new HashSet<>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String path = packageName.replace('.', '/');
            Enumeration<URL> resources = classLoader.getResources(path);

            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                if (resource.getProtocol().equals("file")) {
                    classes.addAll(findClasses(new File(resource.getFile()), packageName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }

    private Set<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        Set<Class<?>> classes = new HashSet<>();
        if (!directory.exists()) return classes;

        File[] files = directory.listFiles();
        if (files == null) return classes;

        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                Class<?> clazz = Class.forName(className);
                classes.add(clazz);
            }
        }
        return classes;
    }

    private void registerCommand(Command command) {
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