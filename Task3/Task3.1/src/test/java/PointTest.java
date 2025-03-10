import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    public void testPointCreation() {
        double x = 3.5;
        double y = 7.2;

        Point point = new Point(x, y);

        assertEquals(x, point.getX());
        assertEquals(y, point.getY());
    }

    @Test
    public void testPointX() {
        Point point = new Point(2.0, 4.0);

        assertEquals(2.0, point.getX());
    }

    @Test
    public void testPointY() {
        Point point = new Point(2.0, 4.0);

        assertEquals(4.0, point.getY());
    }

}
