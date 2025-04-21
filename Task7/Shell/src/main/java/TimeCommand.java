import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeCommand implements Command {
    @Override
    public void execute() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            String time = formatter.format(new Date());
            System.out.println(time);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "time";
    }

    @Override
    public String getDescription() {
        return "time - выводит текущее время";
    }
}