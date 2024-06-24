package figures;

public class Square extends ColoredFigure implements GeometricFigure {
    public double a; // Сторона квадрата

    public Square(double a, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.a = a;
    }

    @Override
    // Периметр квадрата = 4 * а
    public double perimeter() {
        return 4.0 * this.a;
    }

    @Override
    // Площадь квадрата = a^2
    public double area() {
        return this.a * this.a;
    }

    @Override
    public String toString() {
        return "Квадрат [" +
                "Сторона: " + a +
                ' ' + this.getColors() +
                ']';
    }
}