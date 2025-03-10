import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RectangleTest {

    @Test
    public void testArea() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 5);
        Rectangle rectangle = new Rectangle(p1, p2);

        double expectedArea = 6.0;
        assertEquals(expectedArea, rectangle.area(), 20.0);
    }

    @Test
    public void testPerimeter() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 5);
        Rectangle rectangle = new Rectangle(p1, p2);

        double expectedPerimeter = 3 + 4 + 5;
        assertEquals(expectedPerimeter, rectangle.perimeter(), 18);
    }

}
