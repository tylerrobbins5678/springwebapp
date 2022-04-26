package us.tylerrobbins.corewebspring.model;

public class UserPublic {

  private String firstName;
  private String lastName;

  public UserPublic(String firstName, String lastName) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public UserPublic() {
    super();
  }

  public String getfirstName() {
    return firstName;
  }

  public void setfirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getlastName() {
    return lastName;
  }

  public void setlastName(String lname) {
    this.lastName = lname;
  }
}
