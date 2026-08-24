import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

 public class Main {
     public static Student FindStudent(List<Student> students, int id) {

         for (Student student : students) {
             if (student.getId() == id) {
                 return student;
             }
         }
         return null;
     }

     public static Teacher FindTeacher(List<Teacher> teachers, int id) {

         for (Teacher teacher : teachers) {
             if (teacher.getId() == id) {
                 return teacher;
             }
         }
         return null;
     }

     public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);

         List<Student> students = new ArrayList<>();
         List<Teacher> teachers = Teacher.addTeachers();


         while (true) {
             //menu
             System.out.println("------------Welcome!------------");
             System.out.println("If you are a teacher press 1");
             System.out.println("If you are a student press 2");
             System.out.println("If you are want to ext press 3");

             int choice = scan.nextInt();
             scan.nextLine();

             switch (choice) {
                 //teacher
               case 1: {

                   System.out.println("Enter your name:  ");
                   String name = scan.nextLine();
                   System.out.println("Enter your ID:  ");
                   int id = scan.nextInt();
                   scan.nextLine();

                   System.out.println("Enter your password:");
                   String password = scan.nextLine();
                   Teacher teacher = FindTeacher(teachers, id);

                   if (teacher == null) {
                       System.out.println("Teacher not found");
                   } else if (!teacher.checkPassword(password)) {
                       System.out.println("Incorrect password!");
                   } else {
                       System.out.println("welcome " + teacher.getName());
                       teacherMenu(scan, teacher, students);
                   }
                   break;
               }

                 //student
               case 2: {
                   System.out.println("Enter your name:  ");
                   String name = scan.nextLine();
                   System.out.println("Enter your ID:  ");
                   int id = scan.nextInt();
                   System.out.println("Enter your password: ");
                   String password= scan.nextLine();
                   scan.nextLine();

                   Student student = FindStudent(students, id);
                   if (student == null) {
                       System.out.println("Student not found.");
                       System.out.println("Press 1 to retry login");
                       System.out.println("Press 2 to create a new account");

                       int option = scan.nextInt();
                       scan.nextLine();
                       switch (option) {
                           case 1:
                               continue;
                           case 2:

                               student = new Student(name, id,password);
                               students.add(student);
                               System.out.println("Account created successfully");
                               studentMenu(scan, student);
                               break;

                           default:
                               System.out.println("Invalid Choice");
                       }
                   } else {
                       System.out.println("Hello " + student.getName());
                       studentMenu(scan, student);
                   }
                   break;
               }
                 case 3:
                     return;

                 default:
                     System.out.println("Invalid Choice");
             }
         }
     }

     public static void teacherMenu(Scanner scan, Teacher teacher, List<Student> students) {
         while (true) {

             //teacher menu
             System.out.println("To set course--> press 1");
             System.out.println("To set grades--> press 2");
             System.out.println("To display grades--> press 3");
             System.out.println("To exit --> press 4");

             int choice = scan.nextInt();
             scan.nextLine();

             switch (choice) {

                 case 1: {
                     System.out.println("Enter Course name: ");
                     String courseName = scan.nextLine();
                     System.out.println("Enter course code");
                     String courseCode = scan.nextLine();
                     System.out.println("Enter course max grade: ");
                     int maxGrade = scan.nextInt();

                     Course course = new Course(courseName, courseCode, maxGrade);
                     teacher.setcourse(course);
                     System.out.println("Course added Successfully");
                     break;
                 }
                 case 2: {
                     System.out.println("Enter Student ID: ");
                     int studentId = scan.nextInt();
                     scan.nextLine();

                     Student student = FindStudent(students, studentId);
                     if (student == null) {
                         System.out.println("Student not found!");
                     } else {
                         System.out.println("Enter course code:");
                         String courseCode = scan.nextLine();
                         Course selectedCourse = null;

                         for (Course c : Teacher.getAvailableCourses()) {
                             if (c.getCode().equals(courseCode)) {
                                 selectedCourse = c;
                                 break;
                             }
                         }
                         if (selectedCourse == null) {
                             System.out.println("Course not found");
                         } else {
                             System.out.println("Enter Grade:");
                             double grade = scan.nextDouble();
                             teacher.setGrades(student, selectedCourse, grade);
                         }
                     }
                     break;
                 }
                 case 3: {
                     System.out.println("Enter student ID");
                     int studentId = scan.nextInt();

                     Student student = FindStudent(students, studentId);
                     if (student == null) {
                         System.out.println("Student not found!");
                     } else {
                         System.out.println("Student name: " + student.getName());
                         student.displayGrades();
                     }
                     break;
                 }
                 case 4:
                     return;
                 default: {
                     System.out.println("Invalid choice!");
                 }
             }
         }
     }

     public static void studentMenu(Scanner scan, Student student) {
         while (true) {
             System.out.println("To choose courses--> press 1");
             System.out.println("To display grades--> press 2");
             System.out.println("To exit --> press 3");

             int choice = scan.nextInt();
             scan.nextLine();
            switch (choice) {
                case 1: {
                    List<Course> courses = Teacher.getAvailableCourses();

                    System.out.println("Available Courses:");
                    for (int i = 0; i < courses.size(); i++) {
                        Course c = courses.get(i);
                        System.out.println(c.getName() + "       " + c.getCode());
                    }
                    System.out.println("Enter Course code:");
                    String courseCode = scan.nextLine();

                    Course selectedCourse = null;
                    for (Course c : Teacher.getAvailableCourses()) {
                        if (c.getCode().equals(courseCode)) {
                            selectedCourse = c;
                            break;
                        }
                    }
                    if (selectedCourse == null) {
                        System.out.println("Course not found!");
                    } else {
                        student.chooseCourse(selectedCourse);
                    }
                    break;
                }
                case 2: {
                    student.displayGrades();
                    break;
                }
                case 3:
                    return;
                default: {
                    System.out.println("Invalid Choice");
                }
            }
         }
     }
 }


