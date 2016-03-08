import java.util.Scanner;
import java.util.Arrays;

public class Main {
   static Scanner scanner = new Scanner(System.in); 
   static LoanCenter loancenter1 = new LoanCenter();
   static int select = -1;
   
   public static void main(String[] args) { 

    loancenter1.loadResource("/Users/MariaFerman/Desktop/JavaSesiones/Loan/Resource.txt");
    loancenter1.loadStudent("/Users/MariaFerman/Desktop/JavaSesiones/Loan/Student.txt");

    while(select != 0)
      try{ 
        select = menu(select);
        switch(select){
        case 1:
          Scanner scannerResource = new Scanner(System.in); 
          addResource(scannerResource);
          break;
        case 2:
          Scanner scannerStudent = new Scanner(System.in); 
          addStudent(scannerStudent);
          break;
        case 3:
          System.out.println("**** All the Resources ****");
          loancenter1.print_allResources();
          break;
        case 4:
          System.out.println("**** All the Students ****");
          loancenter1.print_allStudents();
          break;
        case 5:
          System.out.println("******* Loan Resource to Student *******");
          Scanner scannerFindResource = new Scanner(System.in); 

          System.out.println("Resource's id: ");
          String id_resource = scannerFindResource.nextLine();
          
          boolean resource_id_exist = loancenter1.find_Resource(id_resource);
          if (resource_id_exist == false){
            System.out.println("Resource doesn't exist or it is already on loan");
            break;
          }
          System.out.println("Resource's id exists: " + resource_id_exist);
          
          System.out.println("Student's id: ");
          String id_student = scannerFindResource.nextLine();
          boolean student_id_exist = loancenter1.find_Student(id_student, id_resource);
          if (student_id_exist == false){
            System.out.println("studet doesn't exist");
            break;
          }
          System.out.println("Student's id exists: " + student_id_exist);
          boolean created = loancenter1.loanResource(id_resource, id_student);
          if (created == true){
            System.out.println("Loan added");
          } else{
            System.out.println("Error!!!");
          }
          break;
        }
      }catch(Exception e){
        System.out.println("Error!");
      }
    }

    public static int menu( int select) {
      System.out.println("******* Menu *******");
      System.out.println("Choose the option");
      System.out.println("1 for Adding a Resource");
      System.out.println("2 for Adding a Student");
      System.out.println("3 for listing all the Resources");
      System.out.println("4 for listing all the Students");
      System.out.println("5 for loan a resource to a Student");
      System.out.println("0 for closing");
      select = Integer.parseInt(scanner.nextLine()); 
      return select;
    }  

    public static void addResource(Scanner scannerResource) {
      System.out.println("**** Resources ****");
      System.out.println("Resource's id: ");
      String id_resource = scannerResource.nextLine();
      System.out.println("Resource's name: ");
      String name_resource = scannerResource.nextLine();
      System.out.println("The Resource is available(true/false): ");
      boolean available = scannerResource.nextBoolean();
      loancenter1.addResource(id_resource, name_resource, available);
    }

    public static void addStudent(Scanner scannerStudent) {
      System.out.println("**** Students ****");
      System.out.println("Student's id: ");
      String id = scannerStudent.nextLine();
      System.out.println("Student's name: ");
      String name = scannerStudent.nextLine();
      System.out.println("The student is registered(true/false): ");
      boolean register = scannerStudent.nextBoolean();
      boolean added =loancenter1.addStudent(id, name, register);
      if (added == true){
        System.out.println("Student added");
      } else{
        System.out.println("Error!!!");
      }
    }
}