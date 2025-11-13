package Shapes;

public sealed abstract class Shape permits Circle, Rectangle, Square {
    
    // A method to be implemented by all subclasses
    public abstract double getArea();
}