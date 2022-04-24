package us.tylerrobbins.corewebspring.model;

public class UserPublic {

  public String fname;
  public String lname;

  public UserPublic(String fname, String lname) {
    super();
    this.fname = fname;
    this.lname = lname;
  }

  public UserPublic() {
    super();
  }

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }
}
