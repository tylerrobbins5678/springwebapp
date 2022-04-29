package us.tylerrobbins.corewebspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPublic {

  protected String fname;
  protected String lname;

  public UserPublic(String fname, String lname) {
    super();
    this.fname = fname;
    this.lname = lname;
  }

  public UserPublic() {
    super();
  }

  @JsonIgnore
  public String getFname() {
    return fname;
  }

  public String getFirstName() {
    return fname;
  }

  public void setFname(String fName) {
    this.fname = fName;
  }

  @JsonIgnore
  public String getLname() {
    return lname;
  }

  public String getLastName() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

}
