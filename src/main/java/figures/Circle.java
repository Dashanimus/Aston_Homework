package figures;

public class Circle extends ColoredFigure implements GeometricFigure {
    public double r; // Радиус круга

    public Circle(double r, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.r = r;
    }

    @Override
    // Периметр круга = 2 * pi * r
    public double perimeter() {
        return 2.0 * this.r * Math.PI;
    }

    @Override
    // Площадь круга = pi * r^2
    public double area() {
        return Math.PI * this.r * this.r;
    }

    @Override
    public String toString() {
        return "Окружность [" +
                "Радиус: " + r +
                ' ' + this.getColors() +
                ']';
    }
}