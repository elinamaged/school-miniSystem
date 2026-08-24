import java.util.ArrayList;
import java.util.List;

public class Teacher extends User{

    private static List<Course> availableCourses=new ArrayList<>();
    private String password;

    public Teacher (String name, int id,String password ){
        super(name,id);
        this.password=password;
    }

    public static List<Course> getAvailableCourses(){
        return availableCourses;
    }

    public void setcourse(Course course) {
        if (!availableCourses.contains(course)) {
            availableCourses.add(course);
        }
        else {
            System.out.println("Course is already available");
        }
    }

    public void setGrades(Student student, Course course, double grade) {
        //check first law course is enrolled -in mycourses
        if (student.checkCourse(course)) {
            if (grade<0 || grade> course.getMaxGrade()){
                System.out.println("invalid grade!!");
            }else {
                student.accessGrade(course, grade);
                System.out.println("Grade added Successfully!");
            }
        }
        else{
            System.out.println("Student is not enrolled to this course :(");
        }
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public static List<Teacher> addTeachers(){
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(new Teacher("Guardiola", 100, "123"));
        teachers.add(new Teacher("Mourinho", 101, "234"));
        teachers.add(new Teacher("Simeone", 102, "345"));
        teachers.add(new Teacher("Bielsa", 103, "456"));
        return teachers;
    }
}

