import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CohortTest {
    Random rand = new Random();
    Cohort cohort = new Cohort();
    List<Student> studentsTest = new ArrayList<>();
    int numberOfStudentsTest;
    double studentsAverageTotal;

    @Before
    public void createCohort() {
        numberOfStudentsTest = rand.nextInt(10) + 5;
        for (int i = 0; i < numberOfStudentsTest; i++) {
            Student student = new Student(i, "Student" + i);
            int numberOfGrades = rand.nextInt(10) + 1;
            for (int j = 0; j < numberOfGrades; j++) {
                int gradeToAdd = rand.nextInt(101);
                student.addGrade(gradeToAdd);
            }
            studentsTest.add(student);
            cohort.addStudent(student);
        }
        for (Student student : studentsTest) {
            studentsAverageTotal += student.getGradeAverage();
        }
    }

    @Test
    public void getCohortAverage() {
        double expected = studentsAverageTotal / studentsTest.size();
        double actual = cohort.getCohortAverage();
        assertEquals(expected, actual, 0.0000000000000001);
    }

    @Test
    public void addStudent() {
        Student student = new Student(1234, "John Coltrane");
        cohort.addStudent(student);
        assertSame(student, cohort.getStudents().get(cohort.getStudents().size() - 1));
    }

    @Test
    public void getStudents() {
        List<Student> expected = studentsTest;
        List<Student> actual = cohort.getStudents();
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
