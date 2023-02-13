package shapes;

public class Circle {
    private final double radius;

    private static int numberOfCircles;

    public Circle(double radius) {
        this.radius = radius;
        numberOfCircles++;
    }

    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    //accessors
    public double getRadius() {
        return radius;
    }

    public static int getNumberOfCircles() {
        return numberOfCircles;
    }
}
