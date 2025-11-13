package Shapes;

public final class FilledRectangle extends Rectangle {
    
    private final String color;

    public FilledRectangle(double width, double height, String color) {
        super(width, height);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}