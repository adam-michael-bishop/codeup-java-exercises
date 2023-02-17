package grades;

import util.Input;

import java.util.*;

public class GradesApplication {
    private final static HashMap<String, Student> students = new HashMap<>();
    private final static Input input = new Input();

    public static void main(String[] args) {
        initStudents();

        do {
            String response = validateResponse();
            printStudentInformation(response);
        } while (input.yesNo("Get info on another student? Y/N"));
    }

    private static String validateResponse() {
        while (true) {
            System.out.printf("%s%n", getStudentUsernamesToString());
            String response = input.getString("Enter a username to get more info on that student.").trim();
            if (students.containsKey(response)) {
                return response;
            } else {
                System.out.println("That is not a valid username!");
            }
        }
    }

    private static void printStudentInformation(String studentKey) {
        Student currentStudent = students.get(studentKey);
        System.out.printf("GitHub username: %s%n", studentKey);
        printStudentName(currentStudent);
        printStudentGradeAverage(currentStudent);
        printStudentGrades(currentStudent);
    }

    private static void printStudentGrades(Student currentStudent) {
        System.out.println("Grades:");
        for (Integer grade : currentStudent.getGrades()) {
            System.out.println(grade);
        }
    }

    private static void printStudentGradeAverage(Student currentStudent) {
        System.out.printf("Grade Average: %.1f%n", currentStudent.getGradeAverage());
    }

    private static void printStudentName(Student currentStudent) {
        System.out.printf("Student: %s%n", currentStudent.getName());
    }

    private static StringJoiner getStudentUsernamesToString() {
        Set<String> keySet = students.keySet();
        return getListOfStringsByDelimiter(keySet, " | ");
    }

    private static StringJoiner getListOfStringsByDelimiter(Collection<String> strings, String delimiter) {
        StringJoiner usernames = new StringJoiner(delimiter);
        for (String string : strings) {
            usernames.add(string);
        }
        return usernames;
    }

    private static void initStudents() {
        Student bob = new Student("Bob Smith");
        Student adam = new Student("Adam Bishop");
        Student joe = new Student("Joe Mama");
        Student sue = new Student("Sue Smith");

        bob.addListOfGrades(List.of(45, 80, 92, 34));
        adam.addListOfGrades(List.of(90, 84, 72, 100));
        joe.addListOfGrades(List.of(92, 33, 60, 87));
        sue.addListOfGrades(List.of(94, 87, 58, 1));

        students.put("bob-smith", bob);
        students.put("adam-bishop", adam);
        students.put("joe-mama", joe);
        students.put("sue-smith", sue);
    }

}
