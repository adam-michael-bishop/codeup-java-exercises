package shapes;

public class Square extends Quadrilateral{
    protected double side;
    public Square(double side) {
        super(side, side);
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.pow(this.length, 2);
    }

    @Override
    public double getPerimeter() {
        return this.length * 4;
    }

    //accessors
    @Override
    public double getLength() {
        return side;
    }

    @Override
    public void setLength(double length) {
        side = length;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public void setWidth(double width) {
        side = width;
    }
}
