package grades;

public class StudentTest {
    public static void main(String[] args) {
        Student bob = new Student("bob", "bob-smith");
        bob.addGrade(90);
        bob.addGrade(95);
        bob.addGrade(87);
        bob.addGrade(94);

        System.out.println("bob.getGradeAverage() = " + bob.getGradeAverage());
    }
}
