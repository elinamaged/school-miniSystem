import java.util.Scanner;
import java.util.ArrayList;


 public class Main {
     public static Student findStud(ArrayList<Student>students, int id){

         for(Student student: students){
             if (student.getId()==id){
                 return student;
             }
         }
         return null;
     }

     public static void main(String[] args){
         Scanner scan=new Scanner(System.in);

         ArrayList<Student> students=new ArrayList<>();


         while (true){
             //menu
             System.out.println("------------Welcome!------------");
             System.out.println("If you are a teacher press 1");
             System.out.println("If you are a student press 2");
             System.out.println("If you are want to ext press 3");

             int choice= scan.nextInt();
             scan.nextLine();

             if(choice==3){
                 break;
             }

             System.out.println("Enter your name:  ");
             String name=scan.nextLine();
             System.out.println("Enter your ID:  ");
             int id =scan.nextInt();

             if (choice==1){
                 Teacher teacher=new Teacher(name,id);

                 //teacher menu
                 System.out.println("To set course--> press 1");
                 System.out.println("To set grades--> press 2");
                 System.out.println("To display grades--> press 3");
                 System.out.println("To exit --> press 4");

                 int Tchoice=scan.nextInt();
                 if (Tchoice==4){
                     break;
                 }

                 if (Tchoice==1){
                     System.out.println("Enter Course name: ");
                     String courseName= scan.nextLine();
                     System.out.println("Enter course");
                     String courseCode= scan.nextLine();

                     Course course= new Course(courseName, courseCode);
                     teacher.setcourse(course);
                     System.out.println("Course added Successfully");

                 } else if (Tchoice==2) {
                     System.out.println("Enter Student ID: ");
                     int studentId= scan.nextInt();

                     Student student=findStud(students, studentId);
                     if (student==null){
                         System.out.println("Student not found!");
                     }
                     else{
                         System.out.println("Enter course code:");
                         String courseCode=scan.nextLine();
                         Course selectedCourse=null;

                         for(Course c: Teacher.getAvailableCourses()){
                             if(c.getCode().equals(courseCode)) {
                                 selectedCourse = c;
                                 break;
                             }
                         }
                        if(selectedCourse==null){
                            System.out.println("Student is not enrolled to this course");
                        }
                        else{
                            System.out.println("Enter Grade:");
                            double grade= scan.nextDouble();
                            teacher.setGrades(student,selectedCourse,grade);
                        }

                     }

                 }


             }




         }

     }

}
