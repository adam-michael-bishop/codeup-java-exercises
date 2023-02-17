package grocerylist;

import util.Input;
import util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class GroceryListApp {
    private static final Input input = new Input();
    private static final ArrayList<String> categories = new ArrayList<>(List.of(
            "dairy",
            "deli",
            "bakery",
            "canned food",
            "beverages",
            "produce",
            "meats",
            "toiletries",
            "frozen food",
            "other"
    ));

    public static void main(String[] args) {
        String userInput;
        String itemCategory;
        String itemName;
        int itemQuantity;
        do {
            System.out.printf("""
                    %s%n""", StringUtils.getStringListByDelimiter(categories, ", "));
            userInput = input.getString("Enter a category:");
            itemCategory = validateCategory(userInput);
            itemName = input.getString("Enter a name");
            itemQuantity = input.getInt(1, 999, "Enter a the amount (1 - 999)");

            GroceryItem newItem = new GroceryItem(itemName, itemCategory, itemQuantity);
            System.out.println(newItem);
        } while (!userInput.trim().equalsIgnoreCase("exit"));
    }

    private static String validateCategory(String userInput) {
        do {
            if (categories.contains(userInput)) {
                return userInput;
            } else {
                System.out.println("not a category!");
            }
            userInput = input.getString("Enter a category:");
        } while (true);
    }
}
