import java.util.ArrayList;
import java.util.List;

public class Teacher extends User{

    private static List<Course> availableCourses=new ArrayList<>();

    public Teacher (String name, int id, String password ){
        super(name,id,password);
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

        if (EnrollmentDB.isEnrolled(student.getId(), course.getCode())) {

            if (grade < 0 || grade > course.getMaxGrade()) {
                System.out.println("Invalid grade!!");
            } else {
                System.out.println("Grade is valid!");
            }

        } else {
            System.out.println("Student is not enrolled in this course :(");
        }
    }
    public boolean checkPassword(String password){
        return this.getPassword().equals(password);
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

