package Shapes;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(10);
        Shape rect = new FilledRectangle(8, 4, "Blue");
        Shape square = new Square(5);

        Shape special = new SpecialSquare(2);

        System.out.println("Circle Area: " + circle.getArea());
        System.out.println("Rectangle Area: " + rect.getArea());
        System.out.println("Square Area: " + square.getArea());
        System.out.println("Special Square Area: " + special.getArea());

    }
}