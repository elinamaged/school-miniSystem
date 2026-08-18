import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User{
    private ArrayList<String> mycourses;

    //
    private HashMap<String, Double> grades;

    public Student (String name, int id){
        super(name,id);
        mycourses = new ArrayList<>();
        grades =new HashMap<>();
    }

    public void accessGrade(String course, Double grade){
        grades.put(course, grade);
    }

    public void chooseCourse(String course){
        if (Teacher.getAvailableCourses(). contains(course) && !(mycourses.contains(course))){
            mycourses.add(course);
            System.out.println(course + "successfully added");
        }
        else {
            System.out.println("course not available");
        }
    }

    public void displayGrades(Student student){
        for (String course: grades.keySet()){
            System.out.println(course+"   "+grades.get(course));
        }
    }

}
