package us.tylerrobbins.corewebspring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import us.tylerrobbins.corewebspring.model.User;
import us.tylerrobbins.corewebspring.repository.UserRepository;

@Service
public class UserAccountManagerService {

  @Autowired
  UserRepository userRepository;


  public String getPublicAccount(String email) {

    Optional<User> account = userRepository.findByEmail(email);

    if (account.isPresent()) {
      return account.get().getFname();
    } else {
      return " ";
    }
  }

  // return full name if login sucecssfull and information about incorrect field if not
  public String userLogin(HashMap<String, String> user) {

    Optional<User> account =
        userRepository.findByEmailAndPassword(user.get("email"), user.get("password"));

    if (account.isPresent()) {
      return account.get().getFname();

    } else if (userRepository.findByEmail(user.get("email")).isPresent()) {
      return "Incorrect Password";

    } else {
      return "Email not found";
    }
  }

  // add a user to users table
  public String addUser(User user) {

    userRepository.save(user);
    return "Sucessful";
  }

  // search users table for accounts with maching paramaters
  public List<User> searchAccounts(Optional<String> fname, Optional<String> lname,
      Optional<String> email) {

    // create User and find all examples
    User user = new User();

    if (fname.isPresent()) {
      user.setFname(fname.get());
    }
    if (lname.isPresent()) {
      user.setLname(lname.get());
    }
    if (email.isPresent()) {
      user.setEmail(email.get());
    }

    // TODO modify to not return password
    return userRepository.findAll(Example.of(user));

  }

  public List<String> getAllUsers() {
    return userRepository.getAllUsers();
  }
}

