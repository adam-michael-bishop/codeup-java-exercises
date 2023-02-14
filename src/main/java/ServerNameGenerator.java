import util.Input;

import java.util.Random;

public class ServerNameGenerator {
    private final String[] adjectives = {
            "chief",
            "lopsided",
            "ethereal",
            "fantastic",
            "rapid",
            "fascinated",
            "whimsical",
            "narrow",
            "divergent",
            "workable"
    };

    private final String[] nouns = {"bath",
            "curve",
            "ants",
            "idea",
            "string",
            "eggnog",
            "floor",
            "vacation",
            "loaf",
            "desire"
    };

    private final Random rand = new Random();

    private String getRandomString(String[] arrayOfStrings) {
        return arrayOfStrings[rand.nextInt(arrayOfStrings.length)];
    }

    public static void main(String[] args) {
        Input input = new Input();
        ServerNameGenerator mySNG = new ServerNameGenerator();
        do {
            String serverName = mySNG.getRandomString(mySNG.adjectives) + '-' + mySNG.getRandomString(mySNG.nouns);
            System.out.printf("Your random server name is %s%n", serverName);
        } while (input.yesNo("Generate a different name? Y/N"));
        System.out.println("Goodbye.");
    }
}
