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
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        do {
            promptAddGroceryItem(groceryList);
            printGroceryList(groceryList);
        } while (true);
    }

    private static void printGroceryList(ArrayList<GroceryItem> groceryList) {

    }

    private static void promptAddGroceryItem(ArrayList<GroceryItem> groceryList) {
        do {
            addGroceryItem(groceryList);
        } while (input.yesNo("Add another grocery item?"));
    }

    private static void addGroceryItem(ArrayList<GroceryItem> groceryList) {
        String userInput;
        String itemCategory;
        String itemName;
        int itemQuantity;
        System.out.printf("""
                %s%n""", StringUtils.getStringListByDelimiter(categories, ", "));
        userInput = input.getString("Enter a category:");
        itemCategory = validateCategory(userInput);
        itemName = input.getString("Enter a name");
        itemQuantity = input.getInt(1, 999, "Enter a the amount (1 - 999)");

        GroceryItem newItem = new GroceryItem(itemName, itemCategory, itemQuantity);
        groceryList.add(newItem);
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
