public class Resource {
  private String id_resource;
  private String name_resource;
  private boolean available; 

  public Resource(String id_resource, String name_resource, boolean available){
    this.id_resource = id_resource;
    this.name_resource = name_resource;
    this.available = available;
  } 

  public String getId() {
    return id_resource;
  }

  public void setId(String id_resource) {
    this.id_resource = id_resource;
  } 

  public String getName() {
    return name_resource;
  }

  public void setName(String name_resource) {
    this.name_resource = name_resource;
  }

  public boolean getAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public String toString() {
    return "Resource's id " + id_resource + " Resource's name " + name_resource + " The resource is available " + available;
  }
}