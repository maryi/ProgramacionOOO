import java.util.*;
import java.io.*;

public class LoanCenter {
  public static ArrayList<Student> listStudents;
  public static ArrayList<Resource> listResources;

  public LoanCenter(){
    listStudents = new ArrayList<Student>();
    listResources = new ArrayList<Resource>();
  }

  public static void main(String[] args){
  } 

  public static boolean addStudent(String id, String name, boolean register){
    Student studentToAdd = new Student(id, name, register);
    listStudents.add(studentToAdd);
    print_student(studentToAdd.getId());
    String fileNameStudent = "Student.txt";
    File fileStudent = new File(fileNameStudent);
    saveStudent(fileStudent);
    return true;
  }

  public static void print_student(String id_student){
   boolean flag = false;
   for (int i = 0; (i < listStudents.size() && flag == false); i++) {
      if (listStudents.get(i).getId().equals(id_student)){
        System.out.println(listStudents.get(i));
        flag = true;
      } 
    } 
    if (flag == false){
    System.out.println ("student doesn't exist");
    }
  }

  public static void addResource(String id_resource, String name_resource, boolean available){
    Resource resourceToAdd = new Resource(id_resource, name_resource, available);
    listResources.add(resourceToAdd);
    print_Resource(resourceToAdd.getId());
    System.out.println("Resource added");
    String fileName = "Resource.txt";
    File file = new File(fileName);
    saveResource(file); 
  }

  public static void print_Resource(String id_resource){
   boolean flag = false;
   for (int i = 0; (i < listResources.size() && flag == false); i++) {
      if (listResources.get(i).getId().equals(id_resource)){
        System.out.println(listResources.get(i));
        flag = true;
      } 
    } 
    if (flag == false){
    System.out.println ("Resource doesn't exist");
    }
  }

  public static void print_allResources(){
    System.out.println(listResources.toString());
  }

  public static void print_allStudents(){
    System.out.println(listStudents.toString());
  }

  public static boolean find_Resource(String id_resource){
    boolean flag = false;
    for (int i = 0; (i < listResources.size() && flag == false); i++) {
      if ((listResources.get(i).getId().equals(id_resource)) && (listResources.get(i).getAvailable() == true)){
        flag = true;
        return true;
      } 
    } 
    if (flag == false){
      return false;
    }
    return false;
  }

  public static boolean find_Student(String id_student, String id_resource){
    boolean flag = false;
    for (int i = 0; (i < listStudents.size() && flag == false); i++) {
      if (listStudents.get(i).getId().equals(id_student) && listStudents.get(i).getRegistered() == true){
        flag = true;
        return true; 
      } 
    } 
    if (flag == false){
      return false;
    }
    return false;
  }

  public static boolean loanResource(String id_resource, String id_student){
    boolean flagResource = false;
    for (int i = 0; (i < listResources.size() && flagResource == false); i++) {
      if (listResources.get(i).getId().equals(id_resource)){
        flagResource = true;
        listResources.get(i).setAvailable(false); 
      } 
    } 
    boolean flagStudent = false;
    for (int i = 0; (i < listStudents.size() && flagStudent == false); i++) {
      if (listStudents.get(i).getId().equals(id_student)){
        flagStudent = true;
        listStudents.get(i).setListLoans(id_resource); 
      } 
    } 
    if (flagResource == false || flagStudent == false){
      return false;
    } else {
      return true;
    } 
  }

  public static void saveResource(File fileName){
     try{  
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName,false)));
      for (Resource resource : listResources){
        pw.print(resource.getId() + ",");
        pw.print(resource.getName()+ ",");
        pw.println(resource.getAvailable());
      }
      pw.close(); // 
    }catch (FileNotFoundException ex){
      System.err.println("Caught IOException: " + ex);
    }catch (IOException ex1){
      System.err.println("Caught IOException: " + ex1);
    }
  }   

  public static void saveStudent(File fileNameStudent){
     try{  
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileNameStudent,false)));
      for (Student student : listStudents){
        pw.print(student.getId() + ",");
        pw.print(student.getName()+ ",");
        pw.print(student.getRegistered()+ ";");
        pw.println(student.getListLoans());
      }
      pw.close(); // 
    }catch (FileNotFoundException ex){
      System.err.println("Caught IOException: " + ex);
    }catch (IOException ex1){
      System.err.println("Caught IOException: " + ex1);
    }
  } 

  public static void loadResource(String filepath){
    try{
        Scanner read = new Scanner(new File(filepath));
        do{
            String line = read.nextLine();
            String[] parsedString = line.split(",");
            listResources.add(new Resource(parsedString[0], parsedString[1], Boolean.parseBoolean(parsedString[2])));
        }while(read.hasNext());
        read.close();
    }catch(FileNotFoundException fnf){
        System.out.println("File was not found.");
    }
  }

  public static void loadStudent(String filepath){
    try{
        Scanner read = new Scanner(new File(filepath));
        do{
            String lineStudent = read.nextLine();
            String[] parsedLoanStudent = lineStudent.split(";");
            // System.out.println("split ;");
            // System.out.println(parsedLoanStudent[1]);
            String[] parsedStringStudent = parsedLoanStudent[0].split(",");
            // System.out.println("split ,");
            // System.out.println(Arrays.toString(parsedStringStudent));
            int size = parsedLoanStudent[1].length();
            ArrayList<String> listLoans = new ArrayList<String>();
            // System.out.println("size");
            // System.out.println(size);
            if (size > 2){
              listLoans.add(parsedLoanStudent[1].substring(1, size - 1));
              // listStudents.add(new Student(parsedStringStudent[0], parsedStringStudent[1], Boolean.parseBoolean(parsedStringStudent[2]), listLoans));
              // System.out.println("What the array has0");
              // System.out.println(listLoans);
            } else {
              // System.out.println("The student doesn't has any loan");
            } 
            listStudents.add(new Student(parsedStringStudent[0], parsedStringStudent[1], Boolean.parseBoolean(parsedStringStudent[2]), listLoans));
        }while(read.hasNext());

        read.close();
    }catch(FileNotFoundException fnf){
        System.out.println("File was not found.");
    }
  }   
}  