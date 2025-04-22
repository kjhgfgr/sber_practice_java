import java.text.SimpleDateFormat;
import java.util.Date;

@Info(
        name = "time",
        description = "Выводит текущее время (формат по умолчанию: HH:mm:ss)"
)
public class TimeCommand implements Command {
    @Override
    public void execute() {
        try {
            exec(new String[0]); // Вызываем exec с пустыми аргументами
        } catch (CommandExecutionException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    @Override
    public void exec(String[] args) throws CommandExecutionException {
        try {
            String format = "HH:mm:ss"; // Формат по умолчанию
            if (args.length > 0 && !args[0].isEmpty()) {
                format = args[0]; // Используем пользовательский формат, если передан
            }
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            System.out.println(formatter.format(new Date()));
        } catch (IllegalArgumentException e) {
            throw new CommandExecutionException("time", "Неверный формат времени. Используйте например: HH:mm:ss");
        } catch (Exception e) {
            throw new CommandExecutionException("time", "Ошибка при выводе времени: " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "time";
    }

    @Override
    public String getDescription() {
        Info info = this.getClass().getAnnotation(Info.class);
        return info != null ? info.name() + " - " + info.description() : "time - выводит текущее время";
    }
}