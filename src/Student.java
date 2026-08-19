import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User{
    private  ArrayList<Course> mycourses;
    private ArrayList<Grades>mygrades;

    //
    //private HashMap<String, Double> grades;

    public Student (String name, int id){
        super(name,id);
        mycourses = new ArrayList<>();
        mygrades = new ArrayList<>();
        //grades =new HashMap<>();
    }

    public void accessGrade(Course course, Double grade){
        mygrades.add(new Grades(course, grade));
    }

    public void chooseCourse(Course newcourse){
        if (Teacher.getAvailableCourses(). contains(newcourse) && !(mycourses.contains(newcourse))){
            mycourses.add(newcourse);
            System.out.println(newcourse + "successfully added");
        }
        else {
            System.out.println("course not available");
        }
    }

    public boolean checkCourse(Course course){
        return mycourses.contains(course);
    }

    public void displayGrades(){
        for (Grades grade: mygrades){
            System.out.println(grade.getCourse().getName() + "   "+grade.getCourse().getCode()
                    +"    "+ grade.getGrade());
        }
    }

}
