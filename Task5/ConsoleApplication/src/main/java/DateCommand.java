import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCommand implements Command {
    @Override
    public void execute() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String date = formatter.format(new Date());
        System.out.println(date);
    }
}
