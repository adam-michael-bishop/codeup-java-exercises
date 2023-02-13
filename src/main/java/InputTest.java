import util.Input;

public class InputTest {
    public static void main(String[] args) {
        Input input = new Input();
        System.out.println(input.getInt(1, 10, "Enter a number between 1 and 10: "));
        System.out.println(input.getString("Say something"));
        input.getDouble(0, 1, "Enter a decimal between 0 and 1: ");
        System.out.println(input.yesNo("Confirm? Y/N"));
    }
}
