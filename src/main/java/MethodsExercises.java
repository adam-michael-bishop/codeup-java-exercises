import java.util.Random;
import java.util.Scanner;

public class MethodsExercises {
    private static final Random rand = new Random();

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        return (double) a / b;
    }

    public static int modulus(int a, int b) {
        return a % b;
    }

    public static int validateInteger(int min, int max, Scanner input) {
        int intToValidate = input.nextInt();
        if (intToValidate >= min && intToValidate <= max) {
            return intToValidate;
        } else {
            System.out.println("Not in range!");
            return validateInteger(min, max, input);
        }
    }

    public static long getFactorial(int number) {
        if (number == 1) {
            return number;
        }
        return number * getFactorial(number - 1);
    }

    public static int rollDie(int sides) {
        return rand.nextInt(sides) + 1;
    }

    public static void main(String[] args) {
        System.out.println("add(5, 3) = " + add(5, 3));
        System.out.println("subtract(5 , 3) = " + subtract(5, 3));
        System.out.println("multiply(5 , 3) = " + multiply(5, 3));
        System.out.println("divide(5 , 3) = " + divide(5, 3));
        System.out.println("modulus(5 , 3) = " + modulus(5, 3));

        Scanner input = new Scanner(System.in);
        boolean doneRollingDice;

        System.out.println("\nEnter a number between 1 and 10");
        int yourNumber = validateInteger(1, 10, input);
        System.out.println("Your number is " + yourNumber + ". Get factorial? Y/N");
        input.nextLine();
        if ("y".equalsIgnoreCase(input.nextLine())) {
            System.out.printf("%d! is equal to %d", yourNumber, getFactorial(yourNumber));
        }
        System.out.println("\nChoose two numbers for sides of a die between 4 and 100");
        int dieOne = validateInteger(4, 100, input);
        System.out.printf("Die one has %d sides%n", dieOne);
        int dieTwo = validateInteger(4, 100, input);
        System.out.printf("Die two has %d sides%n", dieTwo);
        input.nextLine();
        do {
            System.out.printf("""
                                    
                    Rolling dice!
                    d%d rolls %d
                    d%d rolls %d
                                    
                    Roll again? Y/N
                    """, dieOne, rollDie(dieOne), dieTwo, rollDie(dieTwo));
            doneRollingDice = "n".equalsIgnoreCase(input.nextLine());
        } while (!doneRollingDice);
        input.close();
    }
}
