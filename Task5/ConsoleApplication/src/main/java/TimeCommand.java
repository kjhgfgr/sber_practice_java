import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeCommand implements Command {
    @Override
    public void execute() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String time = formatter.format(new Date());
        System.out.println(time);
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
