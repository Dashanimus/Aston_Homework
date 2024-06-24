package figures;

public class Circle extends ColoredFigure implements GeometricFigure {
    public double r;

    public Circle(double r, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.r = r;
    }

    @Override
    public double perimeter() {
        return 2.0 * this.r * Math.PI;
    }

    @Override
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