import java.util.ArrayList;

public class Teacher extends User{

    private static ArrayList<Course> availableCourses=new ArrayList<>();

    public Teacher (String name, int id){
        super(name,id);
    }

    public static ArrayList<Course> getAvailableCourses(){
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

    public void setGrades(Student student, Course course, Double grade) {
        //check first law course is enrolled -in mycourses
        if (student.checkCourse(course)) {
            student.accessGrade(course, grade);
            System.out.println("Grade added Successfully!");
        }
        else{
            System.out.println("Student is not enrolled to this course :(");
        }
    }
}

