package movies;

import util.Input;

import java.util.ArrayList;
import java.util.Arrays;

public class MoviesApplication {
    private final static String helpMessage = """
            all: Shows a list of all movies.
            category: Shows a list of categories to filter by.
            add: Add a new movie to the list with a name and category.
            exit: Exit the program.
            """;
    private static Movie[] movies = MoviesArray.findAll();

    public static void main(String[] args) {
        Input input = new Input();
        String userInput;
        String instructions = """
                Type a command: all | category | add | help | exit""";
        System.out.println(instructions);
        do {
            userInput = input.getString();
            readUserInput(input, userInput, instructions);

        } while (!userInput.trim().equalsIgnoreCase("exit"));
        System.out.println("Goodbye");
    }

    private static void readUserInput(Input input, String userInput, String instructions) {
        if (userInput.trim().equalsIgnoreCase("all")) {
            printMovies();
        } else if (userInput.trim().equalsIgnoreCase("category")) {
            promptCategory(input);
        } else if (userInput.trim().equalsIgnoreCase("help")) {
            System.out.println(helpMessage);
        } else if (userInput.trim().equalsIgnoreCase("add")) {
            promptAddMovie(input);
        } else {
            System.out.println("Sorry I didn't catch that.");
            System.out.println(instructions);
        }
    }

    private static void promptAddMovie(Input input) {
        String movieName;
        String movieCategory;
        do {
            movieName = input.getString("Enter movie title:");
            movieCategory = input.getString("Enter movie category");
            System.out.printf("""
                    %s, %s
                    """, movieName, movieCategory);
        } while (!input.yesNo("Does this look right? Y/N"));
        addMovie(movieName, movieCategory);
    }

    private static void addMovie(String movieName, String movieCategory) {
        Movie movie = new Movie(movieName, movieCategory);
        movies = Arrays.copyOf(movies, movies.length + 1);
        movies[movies.length - 1] = movie;
    }

    private static void promptCategory(Input input) {
        System.out.println("Enter a category. Available categories are:");
        printCategoryList();
        printMovies(input.getString());
    }

    private static void printCategoryList() {
        ArrayList<String> moviesList = new ArrayList<>();
        for (Movie movie: movies) {
            if (!moviesList.contains(movie.getCategory())) {
                System.out.println(movie.getCategory());
                moviesList.add(movie.getCategory());
            }
        }
    }

    private static void printMovies() {
        int longestNameLength = getLongestNameLength();
        System.out.printf("Title | Category%n");
        for (Movie movie : movies) {
            System.out.printf("%7s | %s%n", movie.getName(), movie.getCategory());
        }
        System.out.println("longestNameLength = " + longestNameLength);
    }

    private static int getLongestNameLength() {
        int longestLength = 0;
        for (Movie movie : movies) {
            if (movie.getName().length() > longestLength) {
                longestLength = movie.getName().length();
            }
        }
        return longestLength;
    }

    private static void printMovies(String category) {
        System.out.println("Title | Category");
        for (Movie movie : movies) {
            if (movie.getCategory().equalsIgnoreCase(category.trim())) {
                System.out.printf("%7s | %s%n", movie.getName(), movie.getCategory());
            }
        }
    }
}
