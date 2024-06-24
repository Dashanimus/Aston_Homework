package figures;

// Класс цветных фигур от него наслед. поля с цветами во всех геометрических фигурах
public abstract class ColoredFigure {
    public String fillColor; // Цвет фона фигуры
    public String borderColor; // Цвет границы фигуры

    public ColoredFigure(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getColors() {
        return " Цвет фона:" + fillColor +
                "  Цвет границ:" + borderColor;
    }
}