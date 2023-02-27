import org.apache.commons.lang3.StringUtils;
import util.Input;

public class MavenExercise {
    public static void main(String[] args) {
        Input input = new Input();
        String userInput = input.getString("Enter something: ");
        if(StringUtils.isNumeric(userInput)) {
            System.out.printf("You entered a number: %s%n", userInput);
        } else {
            System.out.printf("You entered: %s%n", userInput);
        }
        System.out.print("Flipped case: ");
        System.out.println(StringUtils.swapCase(userInput));
        System.out.print("Reversed: ");
        System.out.println(StringUtils.reverse(userInput));
    }
}
