public class Triangle extends Figure {
    private Point point2;
    private Point point3;

    public Triangle(Point p1, Point p2, Point p3) {
        super(p1);
        this.point2 = p2;
        this.point3 = p3;
    }

    @Override
    public double area() {
        return 0.5 * ((point2.getX() - point.getX()) * (point3.getY() - point.getY()) - (point2.getY() - point.getY()) * (point3.getX() - point.getX()));
    }

    @Override
    public double perimeter() {
        return distance(point, point2) +
                distance(point2, point3) +
                distance(point3, point);
    }

    private double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX()-b.getX(), 2) +
                Math.pow(a.getY()-b.getY(), 2));
    }

    public void draw() {
        System.out.printf("Треугольник с координатами (%.1f, %.1f), (%.1f, %.1f), (%.1f, %.1f)\n",
                point.getX(), point.getY(),
                point2.getX(), point2.getY(),
                point3.getX(), point3.getY());
    }

    public void draw(Color color) {
        System.out.printf("%s треугольник с координатами (%.1f, %.1f), (%.1f, %.1f), (%.1f, %.1f)\n",
                color,
                point.getX(), point.getY(),
                point2.getX(), point2.getY(),
                point3.getX(), point3.getY());
    }
}
