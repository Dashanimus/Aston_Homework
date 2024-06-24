import animals.Cat;
import figures.Circle;
import figures.Square;
import figures.Triangle;
import figures.GeometricFigure;

public class Main {

    public static void main(String[] args) {
        // Задание 1
        Cat[] cats = new Cat[5];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat();
        }

        System.out.println("В этой миске 20 еды.");
        Cat.Feeder feeder = new Cat.Feeder(20);

        for (Cat cat : cats) {
            cat.feedCat(feeder);
        }

        for (Cat cat : cats) {
            System.out.println(cat);
        }

        System.out.println();

        // Задание 2
        GeometricFigure[] figures = new GeometricFigure[3];
        figures[0] = new Circle(3.0, " оранжевый", " красный");
        figures[1] = new Square(6.0, " чёрный", " белый");
        figures[2] = new Triangle(9.0, 5.0, " розовый", " фиолетовый");

        for (GeometricFigure figure: figures) {
            System.out.println(figure + " Периметр: " + figure.perimeter() +  "  Площадь: " + figure.area());
        }
    }
}
