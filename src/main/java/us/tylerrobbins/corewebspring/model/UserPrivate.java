package us.tylerrobbins.corewebspring.model;

import java.util.List;


public class UserPrivate extends UserPublic {

  private List<Nickname> nicknames;
  private String email;

  public UserPrivate() {

  }

  public UserPrivate(String email, String fname, String lname, List<Nickname> nicknames) {
    super();
    this.email = email;
    this.nicknames = nicknames;
    this.fname = fname;
    this.lname = lname;
  }

  public List<Nickname> getNickNames() {
    return nicknames;
  }

  public void setNickNames(List<Nickname> nickNames) {
    this.nicknames = nickNames;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
