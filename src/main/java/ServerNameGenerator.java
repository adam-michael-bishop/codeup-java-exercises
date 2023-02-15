import util.Input;

import java.util.Random;

public class ServerNameGenerator {
    private static final String[] adjectives = {
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

    private static final String[] nouns = {
            "bath",
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

    private static final Random rand = new Random();

    private static String getRandomString(String[] arrayOfStrings) {
        return arrayOfStrings[rand.nextInt(arrayOfStrings.length)];
    }

    public static void main(String[] args) {
        Input input = new Input();
        do {
            String serverName = getRandomString(adjectives) + '-' + getRandomString(nouns);
            System.out.printf("""
                    Your random server name:
                    %s
                    
                    """, serverName);
        } while (input.yesNo("Generate a different name? Y/N"));
        System.out.println("Goodbye.");
    }
}
