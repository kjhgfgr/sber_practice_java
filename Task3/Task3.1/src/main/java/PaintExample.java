public class PaintExample {
    public static void main(String[] args) {
        Circle circle = new Circle(new Point(0, 0), 4);
        Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(5, 5));
        Triangle triangle = new Triangle(new Point(2, 2), new Point(6, 6), new Point(2, 7));
        Square square = new Square(new Point(3, 3), 8);

        FigureUtil.draw(triangle, Color.PINK);
        System.out.printf("Площадь треугольника: %.2f\n", FigureUtil.area(triangle));
        System.out.printf("Периметр треугольника: %.2f\n", FigureUtil.perimeter(triangle));
        System.out.println();

        FigureUtil.draw(circle, Color.RED);
        System.out.printf("Площадь круга: %.2f\n", FigureUtil.area(circle));
        System.out.printf("Периметр круга: %.2f\n", FigureUtil.perimeter(circle));
        System.out.println();

        FigureUtil.draw(rectangle, Color.BLUE);
        System.out.printf("Площадь прямоугольника: %.2f\n", FigureUtil.area(rectangle));
        System.out.printf("Периметр прямоугольника: %.2f\n", FigureUtil.perimeter(rectangle));
        System.out.println();

        FigureUtil.draw(square, Color.GREEN);
        System.out.printf("Площадь квадрата: %.2f\n", FigureUtil.area(square));
        System.out.printf("Периметр квадрата: %.2f\n", FigureUtil.perimeter(square));
    }
}
