import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Double> grades;

    public Student(String name){
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    public void addGrade(double grade){
        this.grades.add(grade);
    }

    public List<Double> getGrades() {
        return grades;
    }

    public double getAverage(){
        if(grades.isEmpty()) return 0;
        double sum = 0;
        for (double element:grades){
            sum+=element;
        }
        return sum/grades.size();
    }
}
