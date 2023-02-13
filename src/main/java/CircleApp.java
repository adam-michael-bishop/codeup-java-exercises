import shapes.Circle;
import util.Input;

public class CircleApp {
    public static void main(String[] args) {
        Input input = new Input();
        do {
            double radius = input.getDouble(0, Double.MAX_VALUE, "Enter a non-negative number for a circle's radius: ");
            Circle circle = new Circle(radius);
            System.out.printf("""
                    Your circle has a radius of %f.
                    Circumference is %f.
                    Area is %f.
                                    
                    cool.
                    """, circle.getRadius(), circle.getCircumference(), circle.getArea());

        } while (input.yesNo("Wanna make another one? Y/N"));
        System.out.printf("You made %d circles.", Circle.getNumberOfCircles());
    }
}
