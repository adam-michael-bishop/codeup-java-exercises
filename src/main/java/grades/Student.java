package grades;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final String username;
    private final ArrayList<Integer> grades;

    public Student(String name, String username) {
        this.name = name;
        this.username = username;
        grades = new ArrayList<>();
    }

    // returns the student's name
    public String getName(){
        return name;
    }
    // adds the given grade to the grades property
    public void addGrade(int grade){
        grades.add(grade);
    }

    public void addListOfGrades(List<Integer> grades){
        for (Integer grade : grades) {
            addGrade(grade);
        }
    }
    // returns the average of the students grades
    public double getGradeAverage(){
        int gradeTotal = 0;
        for (Integer grade : grades) {
            gradeTotal += grade;
        }
        return (double) gradeTotal / grades.size();
    }

    //accessor

    public String getUsername() {
        return username;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }
}
