package shapes;

public class Rectangle extends Quadrilateral implements Measurable{
    protected double length;
    protected double width;

    public Rectangle(double length, double width) {
        super(length, width);
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return this.length * this.width;
    }

    public double getPerimeter() {
        return (2 * this.length) + (2 * this.width);
    }
}
