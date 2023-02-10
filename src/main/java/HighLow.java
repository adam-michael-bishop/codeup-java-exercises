import java.util.Random;
import java.util.Scanner;

public class HighLow {
    private static final Random rand = new Random();
    private static final int numberOfGuesses = 6;
    private static final int maxNumber = 100;
    private static final int minNumber = 1;
    private static final String[] winMessages = {
            "Good guess! Probably just got lucky...",
            "Nice! Took you long enough...",
            "Wow! Really didn't expect much from you...",
            "Finally! I almost fell asleep."
    };
    private static final String[] loseMessages = {
            "HAHAHAHAHAHA!!!! You suck.",
            "Honestly this is just embarrassing.",
            "Try turning your monitor on next time. :)",
            "Game over man, game over!"
    };

    private static int validateInteger(int min, int max, Scanner input) {
        int intToValidate = input.nextInt();
        if (intToValidate >= min && intToValidate <= max) {
            return intToValidate;
        } else {
            System.out.println("Not in range!");
            return validateInteger(min, max, input);
        }
    }

    private static void playGame(int superSecretNumber, Scanner input) {
        boolean isDonePlaying;
        int currentGuesses;
        do {
            currentGuesses = numberOfGuesses;
            System.out.printf("Pick a number between %d and %d: ", minNumber, maxNumber);
            int guessedNumber = validateInteger(minNumber, maxNumber, input);
            while (guessedNumber != superSecretNumber) {
                currentGuesses--;
                if (currentGuesses <= 0) {
                    break;
                }
                if (guessedNumber > superSecretNumber) {
                    System.out.printf("LOWER%s%n",guessedNumber == 69 ? " (Nice)" : "");
                }
                if (guessedNumber < superSecretNumber) {
                    System.out.printf("HIGHER%s%n", guessedNumber == 69 ? " (Nice)" : "");
                }
                if (currentGuesses == 1) {
                    System.out.printf("%d try left. No pressure :)%n", currentGuesses);
                } else {
                    System.out.printf("%d tries left%n", currentGuesses);
                }
                guessedNumber = validateInteger(minNumber, maxNumber, input);
            }
            if (currentGuesses == 0) {
                System.out.printf("""
                        L
                        Number was %d%s
                        
                        %s
                        
                        Play again? Y/N
                        """,superSecretNumber,superSecretNumber == 69 ? " (Nice)" : "",getRandomLoseMessage());
            } else {
                System.out.printf("""
                        W
                                            
                        %s
                                            
                        Play again? Y/N
                        """, getRandomWinMessage(currentGuesses));
            }
            input.nextLine();
            isDonePlaying = "n".equalsIgnoreCase(input.nextLine());
            superSecretNumber = rand.nextInt(maxNumber) + 1;
        } while (!isDonePlaying);
    }

    private static String getRandomWinMessage(int currentGuesses) {
        if (currentGuesses == numberOfGuesses) {
            return "Cheater...";
        }
        return winMessages[rand.nextInt(winMessages.length)] + "\n(Number found in " + (numberOfGuesses - currentGuesses + 1) + " tries)";
    }

    private static String getRandomLoseMessage() {
        return loseMessages[rand.nextInt(loseMessages.length)];
    }

    public static void main(String[] args) {
        int superSecretNumber = rand.nextInt(maxNumber) + 1;
        Scanner input = new Scanner(System.in);

        playGame(superSecretNumber, input);

        input.close();
    }
}