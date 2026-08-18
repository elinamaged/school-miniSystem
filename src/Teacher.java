import java.util.ArrayList;

public class Teacher extends User{

    private static ArrayList<String> availableCourses=new ArrayList<>();

    public Teacher (String name, int id){
        super(name,id);
    }

    public void setcourse(String course){
        availableCourses.add(course);
    }

    public static ArrayList<String> getAvailableCourses(){
        return availableCourses;
    }

    public void setGrades(Student student, String course, Double grade){
        //check first law course is enrolled -in mycourses
        student.accessGrade(course, grade);
    }
}

