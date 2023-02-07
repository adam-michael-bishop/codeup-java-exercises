package hello;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world!!!!!!!");
        int myFavoriteNumber = 42;
        System.out.println("myFavoriteNumber = " + myFavoriteNumber);
        String myString = "Adam Bishop";
        System.out.println("myString = " + myString);
        float myNumber = 3.14f;
        System.out.println("myNumber = " + myNumber);
//        int x = 5;
//        System.out.println(x++);
//        System.out.println(x);
//        int x = 5;
//        System.out.println(++x);
//        System.out.println(x);
//        String theNumberThree = "three";
//        Object o = theNumberThree;
//        int three = (int) o;
//        System.out.println("three = " + three)
        // 13.
//        int x = 4;
//        x += 5;
//        System.out.println("x = " + x);
//        int x = 3;
//        int y = 4;
//        y *= x;
//        System.out.println("y = " + y);
        int x = 10;
        int y = 2;
        x /= y;
        System.out.println("x = " + x);
        y -= x;
        System.out.println("y = " + y);
        // 14.
        int maxIntValue = Integer.MAX_VALUE + 1;
        System.out.println("maxIntValue = " + maxIntValue);
        maxIntValue++;
        System.out.println("maxIntValue = " + maxIntValue);
    }
}
