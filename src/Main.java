import java.util.Scanner;
import java.util.ArrayList;
 public class Main {
     public static void main(String[] args){
         Scanner scan=new Scanner(System.in);

         ArrayList<Student> students=new ArrayList<>();

         while (true){
             System.out.println("------------Welcome!------------");
             System.out.println("If you are a teacher press 1");
             System.out.println("If you are a student press 2");
             System.out.println("If you are want to ext press 3");

             int choice= scan.nextInt();
             scan.nextLine();

             if(choice==3){
                 break;
             }



         }
     }
}