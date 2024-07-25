import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while(true){
            System.out.println("Enter the name of the Student or type 'exit' to finish: ");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("exit")) break;

            Student student = new Student(name);
            while(true){
                System.out.println("Enter marks for "+name+" or type 'done' to finish: ");
                String marksInput = sc.nextLine();
                if (marksInput.equalsIgnoreCase("done")) break;
                try{
                    double marks = Double.parseDouble(marksInput);
                    student.addGrade(marks);
                }catch (NumberFormatException e){
                    System.out.println("Invalid format. Enter valid format.");
                }
            }
            students.add(student);
        }
        System.out.println("\nStudent Grades:");
        for(Student element:students){
            double average = element.getAverage();
            char grade = GradeCalculator.calculateGrade(average);
            System.out.println("Name: "+element.getName());
            System.out.println("Marks: "+element.getGrades());
            System.out.println("Average: "+average);
            System.out.println("Final Grade: "+grade+".\n");
        }
        sc.close();
    }
}
