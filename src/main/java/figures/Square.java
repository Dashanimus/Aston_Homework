package figures;

public class Square extends ColoredFigure implements GeometricFigure {
    public double a;

    public Square(double a, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.a = a;
    }

    @Override
    public double perimeter() {
        return 4.0 * this.a;
    }

    @Override
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