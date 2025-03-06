public class FigureUtil {
    private FigureUtil() {}

    public static double area(Figure figure) {
        return figure.area();
    }

    public static double perimeter(Figure figure) {
        return figure.perimeter();
    }

    public static void draw(Figure figure) {
        if (figure instanceof Circle) {
            ((Circle) figure).draw();
        } else if (figure instanceof Rectangle) {
            ((Rectangle) figure).draw();
        } else if (figure instanceof Triangle) {
            ((Triangle) figure).draw();
        }
    }

    public static void draw(Figure figure, Color color) {
        if (figure instanceof Circle) {
            ((Circle) figure).draw(color);
        } else if (figure instanceof Rectangle) {
            ((Rectangle) figure).draw(color);
        } else if (figure instanceof Triangle) {
            ((Triangle) figure).draw(color);
        }
    }
}