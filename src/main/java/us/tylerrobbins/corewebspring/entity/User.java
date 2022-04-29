package us.tylerrobbins.corewebspring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
  @Id
  private Integer id;
  private String email;
  private String fname;
  private String lname;
  private String password;

  public User() {

  }

  public User(String email, String fname, String lname, String password, Integer id) {
    super();
    this.id = id;
    this.email = email;
    this.fname = fname;
    this.lname = lname;
    this.password = password;
  }

  @JsonIgnore
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @JsonIgnore
  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @JsonIgnore
  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }

  @JsonIgnore
  public String getFname() {
    return fname;
  }


  public void setFname(String fname) {
    this.fname = fname;
  }

  @JsonIgnore
  public String getLname() {
    return lname;
  }


  public void setLname(String lname) {
    this.lname = lname;
  }

  // getters for Jackson / JSON friendly names
  public String getUserEmail() {
    return email;
  }

  public String getFirstName() {
    return fname;
  }

  public String getLastName() {
    return lname;
  }
}
