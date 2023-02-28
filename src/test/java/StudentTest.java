import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    private Student student;
    private int numberOfGrades;
    double gradeTotal;

    @Before
    public void createStudent() {
        student = new Student(1234, "Adam");
        Random rand = new Random();
        numberOfGrades = rand.nextInt(50) + 1;
        for (int i = 0; i < numberOfGrades; i++) {
            int gradeToAdd = rand.nextInt(101);
            gradeTotal += gradeToAdd;
            student.addGrade(gradeToAdd);
        }
    }

    @Test
    public void testStudentConstructor() {
        assertEquals(1234, student.getId());
        assertEquals("Adam", student.getName());
    }

    @Test
    public void testStudentAddGrade() {
        Integer gradeTest = 100;
        student.addGrade(gradeTest);
        assertEquals(gradeTest, student.getGrades().get(student.getGrades().size() - 1));
    }

    @Test
    public void testStudentAddMultipleGrades() {
        assertEquals(numberOfGrades, student.getGrades().size());
    }

    @Test
    public void testStudentGetGradeAverage() {
        double expected = gradeTotal / numberOfGrades;
        double actual = student.getGradeAverage();

        assertEquals(expected, actual, 0.000000000000000001);
    }
}
