import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    public void testArea() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(0, 3);
        Triangle triangle = new Triangle(p1, p2, p3);

        double expectedArea = 6.0;
        assertEquals(expectedArea, triangle.area(), 0.001);
    }

    @Test
    public void testPerimeter() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 0);
        Point p3 = new Point(0, 4);
        Triangle triangle = new Triangle(p1, p2, p3);

        double expectedPerimeter = 3 + 4 + 5; // Стороны: 3, 4, 5
        assertEquals(expectedPerimeter, triangle.perimeter(), 0.001);
    }
    
}
