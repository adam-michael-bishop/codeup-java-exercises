import java.util.Random;
import java.util.Scanner;

public class HighLow {
    private static final Random rand = new Random();
    private static final int maxNumber = 100;
    private static final int minNumber = 1;

    private static int validateInteger(int min, int max, Scanner input) {
        int intToValidate = input.nextInt();
        if (intToValidate >= min && intToValidate <= max) {
            return intToValidate;
        } else {
            System.out.println("Not in range!");
            return validateInteger(min, max, input);
        }
    }

    public static void main(String[] args) {
        boolean isDonePlaying = false;
        int superSecretNumber = rand.nextInt(maxNumber) + 1;
        Scanner input = new Scanner(System.in);

        do {
            System.out.printf("Pick a number between %d and %d: ", minNumber, maxNumber);
            int guessedNumber = validateInteger(minNumber, maxNumber, input);

            while (guessedNumber != superSecretNumber) {
                if (guessedNumber > superSecretNumber) {
                    System.out.println("LOWER");
                }
                if (guessedNumber < superSecretNumber) {
                    System.out.println("HIGHER");
                }
                guessedNumber = validateInteger(minNumber, maxNumber, input);
            }

            System.out.println("""
                    
                    GOOD GUESS!
                    
                    Play again? Y/N
                    """);
            input.nextLine();
            isDonePlaying = "n".equalsIgnoreCase(input.nextLine());
            superSecretNumber = rand.nextInt(maxNumber) + 1;
        } while (!isDonePlaying);

        input.close();
    }
}
