import java.util.*;

public class Student {
  private String id;
  private String name;
  private boolean registered; 
  private ArrayList<String> listLoans;
 
  public Student(String id, String name, boolean registered ){
    this.id = id;
    this.name = name;
    this.registered = registered;
    this.listLoans = new ArrayList<String>();
  } 

  public Student(String id, String name, boolean registered, ArrayList<String> loanList ){
    this.id = id;
    this.name = name;
    this.registered = registered;
    this.listLoans = loanList;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  } 

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean getRegistered() {
    return registered;
  }

  public void setRegistered(boolean registerd) {
    this.registered = registerd;
  }

  public ArrayList getListLoans() {
    return listLoans;
  }

  public void setListLoans(String resourceId) {
    this.listLoans.add(resourceId);
  }

  public String toString() {
    return "id " + id + " name " + name + " registered " + registered + " List loans " + listLoans;
  }
}