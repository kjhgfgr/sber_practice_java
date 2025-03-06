public class Circle extends Figure {
    private double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public void draw() {
        System.out.printf("Круг с центром (%.1f, %.1f) и радиусом %.1f\n",
                point.getX(), point.getY(), radius);
    }

    public void draw(Color color) {
        System.out.printf("%s круг с центром (%.1f, %.1f) и радиусом %.1f\n",
                color, point.getX(), point.getY(), radius);
    }
}