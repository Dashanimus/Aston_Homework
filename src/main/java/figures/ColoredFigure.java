package figures;

public abstract class ColoredFigure {
    public String fillColor;
    public String borderColor;

    public ColoredFigure(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getColors() {
        return " Цвет фона:" + fillColor +
                "  Цвет границ:" + borderColor;
    }
}