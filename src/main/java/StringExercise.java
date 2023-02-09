public class StringExercise {
    public static void main(String[] args) {
        String anotherBrick = """
                We don't need no education
                We don't need no thought control
                """;
        System.out.println(anotherBrick);

        String quoteString = "Check \"this\" out!, \"s inside of \"s!";
        System.out.println(quoteString);

        String windowsString = "In windows, the main drive is usually C:\\";
        System.out.println(windowsString);

        String backslashString = """
                I can do backslashes \\, double backslashes \\\\,
                and the amazing triple backslash \\\\\\!
                """;
        System.out.println(backslashString);
    }
}
