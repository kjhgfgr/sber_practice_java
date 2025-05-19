import java.io.IOException;
import java.util.List;

public interface Path {
    List<String> readFile(String path) throws IOException;
}