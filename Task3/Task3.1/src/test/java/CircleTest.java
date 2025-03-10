import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CircleTest {

    @Test
    public void testArea() {
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 1);
        double expectedArea = Math.PI * 1 * 1;
        assertEquals(expectedArea, circle.area(), 0.0001);
    }

    @Test
    public void testPerimeter() {
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 1);
        double expectedPerimeter = 2 * Math.PI * 1;
        assertEquals(expectedPerimeter, circle.perimeter(), 0.0001);
    }

}
