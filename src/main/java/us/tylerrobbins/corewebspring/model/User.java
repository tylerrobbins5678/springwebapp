package us.tylerrobbins.corewebspring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  @Id
  private String email;
  private String fname;
  private String lname;
  private String password;

  public User() {

  }

  public User(String email, String fname, String lname, String password) {
    super();
    this.email = email;
    this.fname = fname;
    this.lname = lname;
    this.password = password;
  }

  // unpopular opinion to have login method in DAO, but this adds more security
  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
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

  // simplify
  public String getFullName() {
    return this.fname + " " + this.lname;
  }
}
