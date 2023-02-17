package grades;

import util.Input;

import java.util.*;

public class GradesApplication {
    private final static HashMap<String, Student> STUDENT_HASH_MAP = new HashMap<>();
    private final static ArrayList<Student> studentsList = new ArrayList<>();
    private final static Input input = new Input();
    private final static ArrayList<String> commands = new ArrayList<>(List.of(
            "info", "all grades", "class avg", "csv", "exit"));
    
    public static void main(String[] args) {
        initStudents();
        String userInput;
        do {
            userInput = promptMainMenu();
            parseMainMenuInput(userInput);
        } while (!userInput.trim().equalsIgnoreCase(commands.get(commands.size() - 1)));
    }

    private static void parseMainMenuInput(String userInput) {
        switch (userInput) {
            case "info" -> promptGetStudentInfo();
            case "all grades" -> printAllGrades();
            case "class avg" -> printClassAverage();
            case "csv" -> printCSVReport();
        }
    }

    private static void printCSVReport() {
        for (Student student : studentsList) {
            System.out.println(getStudentCSVLine(student));
        }
    }

    private static StringJoiner getStudentCSVLine(Student student) {
        StringJoiner studentCSVLine = new StringJoiner(",");
        studentCSVLine.add(student.getName());
        studentCSVLine.add(student.getUsername());
        studentCSVLine.add(Double.toString(student.getGradeAverage()));
        return studentCSVLine;
    }

    private static void printClassAverage() {
        System.out.printf("Class Average Grade: %.2f%n", getClassAverageGrade());
    }

    private static double getClassAverageGrade() {
        double totalAverage = 0;
        for (Student student : studentsList) {
            totalAverage += student.getGradeAverage();
        }
        return totalAverage / studentsList.size();
    }

    private static void printAllGrades() {
        System.out.println("Here is a list of all student grades:");
        for (Student student : studentsList) {
            printStudentName(student);
            printStudentGrades(student);
        }
    }

    private static void promptGetStudentInfo() {
        do {
            String githubUsername = validateGithubUsername();
            printStudentInformation(githubUsername);
        } while (input.yesNo("Get info on another student? Y/N"));
    }

    private static String promptMainMenu() {
        String userInput;
//        ArrayList<String> commandsList = new ArrayList<>(List.of(Commands));
        System.out.printf("""
                    Available commands:
                    %s
                    """, getStringListByDelimiter(commands, " | "));
        do {
            userInput = input.getString();
            if (commands.contains(userInput)) {
                return userInput;
            } else {
                System.out.println("command not found!");
            }
        } while (true);
    }

    private static String validateGithubUsername() {
        while (true) {
            System.out.printf("%s%n", getStudentUsernamesToString());
            String githubUsername = input.getString("Enter a username to get more info on that student.").trim();
            if (STUDENT_HASH_MAP.containsKey(githubUsername)) {
                return githubUsername;
            } else {
                System.out.println("That is not a valid username!");
            }
        }
    }

    private static void printStudentInformation(String studentKey) {
        Student currentStudent = STUDENT_HASH_MAP.get(studentKey);
        System.out.printf("GitHub username: %s%n", studentKey);
        printStudentName(currentStudent);
        printStudentGradeAverage(currentStudent);
        printStudentGrades(currentStudent);
    }

    private static void printStudentGrades(Student currentStudent) {
        System.out.printf("Grades: %s%n", getStringListByDelimiter(currentStudent.getGrades(), ", "));
    }

    private static void printStudentGradeAverage(Student currentStudent) {
        System.out.printf("Grade Average: %.1f%n", currentStudent.getGradeAverage());
    }

    private static void printStudentName(Student currentStudent) {
        System.out.printf("Student: %s%n", currentStudent.getName());
    }

    private static StringJoiner getStudentUsernamesToString() {
        Set<String> keySet = STUDENT_HASH_MAP.keySet();
        return getStringListByDelimiter(keySet, " | ");
    }

    private static StringJoiner getStringListByDelimiter(Collection<?> objects, String delimiter) {
        StringJoiner usernames = new StringJoiner(delimiter);
        for (Object object : objects) {
            if (object instanceof String) {
                usernames.add((String) object);
            }
            if (object instanceof Integer) {
                usernames.add(Integer.toString((int) object));
            }
        }
        return usernames;
    }

    private static void initStudents() {
        Student bob = new Student("Bob Smith", "bob-smith");
        Student adam = new Student("Adam Bishop", "adam-bishop");
        Student joe = new Student("Joe Mama", "joe-mama");
        Student sue = new Student("Sue Smith", "sue-smith");
        
        studentsList.addAll(List.of(bob, adam, joe, sue));

        bob.addListOfGrades(List.of(45, 80, 92, 34));
        adam.addListOfGrades(List.of(90, 84, 72, 100));
        joe.addListOfGrades(List.of(92, 33, 60, 87));
        sue.addListOfGrades(List.of(94, 87, 58, 1));

        STUDENT_HASH_MAP.put(bob.getUsername(), bob);
        STUDENT_HASH_MAP.put(adam.getUsername(), adam);
        STUDENT_HASH_MAP.put(joe.getUsername(), joe);
        STUDENT_HASH_MAP.put(sue.getUsername(), sue);
    }

}
