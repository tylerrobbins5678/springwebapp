package us.tylerrobbins.corewebspring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import us.tylerrobbins.corewebspring.model.User;
import us.tylerrobbins.corewebspring.model.UserPublic;

public interface UserAccountManagerService {

  List<UserPublic> getAllUsers();

  String userLogin(HashMap<String, String> user);

  String getPublicAccount(String email);

  List<User> searchAccounts(Optional<String> fname, Optional<String> lname, Optional<String> email);

  String addUser(User user);

}
