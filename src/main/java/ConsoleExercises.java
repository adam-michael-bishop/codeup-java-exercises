import java.util.Scanner;

public class ConsoleExercises {
    public static void main(String[] args) {
        double pi = 3.14159;
        Scanner input = new Scanner(System.in);

        System.out.printf("The value of pi is approximately %.2f.\n", pi);
        System.out.print("Please enter a number (NO DECIMALS!!): ");
        int userNumber = input.nextInt();

        System.out.printf("Your number is %d%n", userNumber);
        System.out.print("Press enter to continue");
        input.nextLine();
        input.nextLine();

        System.out.println("Enter 3 words pls...");
        String firstWord = input.next();
        String secondWord = input.next();
        String thirdWord = input.next();
        System.out.printf("These are your words:%n%s%n%s%n%s%n", firstWord, secondWord, thirdWord);
        input.nextLine();

        System.out.println("Write a cool sentence, not too long though...");
        String userSentence = input.nextLine();
        System.out.printf("Your sentence is the following:%n%s%n", userSentence);
        input.useDelimiter("\n");

        System.out.printf("Now we will calculate the area of the room you are in.%nPlease enter the width and length%n");
        int roomWidth = input.nextInt();
//        System.out.print("Length: ");
        int roomLength = input.nextInt();
        int roomArea = roomLength * roomWidth;
        System.out.printf("The area of the room is %d.", roomArea);

        input.close();
    }
}
