package figures;

public class Triangle extends ColoredFigure implements GeometricFigure {
    public double a, b;

    public Triangle(double a, double b, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.a = a;
        this.b = b;
    }

    @Override
    public double perimeter() {
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        return this.a + this.b + c;
    }

    @Override
    public double area() {
        return this.a * this.b / 2.0;
    }

    @Override
    public String toString() {
        return "Треугольник [" +
                "Катет a:" + a +
                "  Катет b:" + b +
                ' ' + this.getColors() +
                ']';
    }
}