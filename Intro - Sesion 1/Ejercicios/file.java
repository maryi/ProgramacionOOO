import java.util.Scanner;
import java.io.*;
//path to write
//Users/MariaFerman/lighthouse/JavaProgramming/directoryTest

public class file {
  public static void main(String [] args) {
    String filePathString = getPath();
    File f = new File(filePathString);
    if(f.exists() ) { 
      if (f.isDirectory() ){
        listFiles(f);
        File newFile = createFile();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Do you want to delete the test.txt(yes/no)? ");
        String answer = input2.nextLine();
        if(answer.equals("yes")){ //why (answer == "yes") == is for datos primitivos
           deleteFile(newFile);
        }
      }
      else{
        filecanRead(f);
        filecanWrite(f);
      }
    }
  }

  public static String getPath() {
    Scanner input = new Scanner(System.in);
    System.out.print("Write a path: ");
    String path = input.nextLine();
    return path;
  } 

// .listFiles -> returns an array of pathnames for files and directories
  public static void listFiles(File f) {
    File[] listOfFiles = f.listFiles();
    for (File file : listOfFiles) {
      if (file.isFile() ) { //only the files(without directories)
          System.out.println(file.getName());
      }
    }
  }
// public static File newF; //how to solve this without a global variable?
  public static File createFile() {
      File newf = null; 
      try {
          newF = new File("/Users/MariaFerman/lighthouse/JavaProgramming/directoryTest/test.txt");
        if (newF.createNewFile()){
          System.out.println("File is created!");
        }else{
          System.out.println("File already exists.");
        }
      } 
       catch (IOException e) {
        e.printStackTrace();
    }
    return newF;
  }  

    public static void deleteFile(File file) {
      if(file.delete()){
          System.out.println(file.getName() + " is deleted!");
        }else{
          System.out.println("Delete operation is failed.");
        }
    }

    public static void filecanRead(File file) {
      if (file.canRead()) {
        System.out.println(file.getName() + " Can be Ridden ");
        } 
    }

    public static void filecanWrite(File file) {
      if (file.canWrite()) {
          System.out.println(file.getName() + "Can Write ");
        }
    }
}