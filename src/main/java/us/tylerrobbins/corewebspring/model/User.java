package us.tylerrobbins.corewebspring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  @Id
  private int id;
  private String email;
  private String fname;
  private String lname;
  private String password;

  public User() {

  }

  public User(String email, String fname, String lname, String password, int id) {
    super();
    this.id = id;
    this.email = email;
    this.fname = fname;
    this.lname = lname;
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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
}
