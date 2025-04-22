import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCommand implements Command {
    @Override
    public void execute() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String date = formatter.format(new Date());
            System.out.println(date);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "date";
    }

    @Override
    public String getDescription() {
        return "выводит текущую дату";
    }
}