import java.util.Scanner;

public class Bob {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean done;
        String statement;
        do {
            System.out.println("Say something to Bob...");
            statement = input.nextLine();
            System.out.print("Bob says: ");

            if (statement.endsWith("?")) {
                System.out.println("'Sure.'");
            }
            else if (statement.endsWith("!")) {
                System.out.println("'Whoa, chill out!'");
            }
            else if (statement.trim().length() == 0) {
                System.out.println("'Fine. Be that way!'");
            } else {
                System.out.println("'Whatever.'");
            }

            System.out.print("""
                    Bob is staring off into space...
                    Continue the conversation? Y/N
                    """);
            done = "n".equalsIgnoreCase(input.nextLine());
        } while (!done);
        input.close();
    }
}
