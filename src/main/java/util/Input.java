package util;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public String getString() {
        scanner.nextLine();
        return scanner.nextLine();
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        return getString();
    }

    public boolean yesNo() {
        scanner.nextLine();
        String answer = getString();
        return answer.equalsIgnoreCase("y") ||
                answer.equalsIgnoreCase("ye") ||
                answer.equalsIgnoreCase("yes") ||
                answer.equalsIgnoreCase("yup") ||
                answer.equalsIgnoreCase("yeah");
    }

    public boolean yesNo(String prompt) {
        System.out.println(prompt);
        return yesNo();
    }

    public int getInt(int min, int max) {
        int userInput = getInt();
        while (userInput < min || userInput > max) {
            System.out.printf("Must be between %d and %d.%n", min, max);
            userInput = getInt();
        }
        return userInput;
    }

    public int getInt(int min, int max, String prompt) {
        System.out.print(prompt);
        return getInt(min, max);
    }

    public int getInt() {
        return scanner.nextInt();
    }

    public int getInt(String prompt) {
        System.out.print(prompt);
        return getInt();
    }

    public double getDouble(double min, double max) {
        double userInput = getDouble();
        while (userInput < min || userInput > max) {
            System.out.printf("Must be between %f and %f.%n", min, max);
            userInput = getDouble();
        }
        return userInput;
    }

    public double getDouble(double min, double max, String prompt) {
        System.out.print(prompt);
        return getDouble(min, max);
    }

    public double getDouble() {
        return scanner.nextDouble();
    }

    public double getDouble(String prompt) {
        System.out.print(prompt);
        return getDouble();
    }
}
