package us.tylerrobbins.corewebspring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import us.tylerrobbins.corewebspring.RESTservice.RestService;
import us.tylerrobbins.corewebspring.entity.User;
import us.tylerrobbins.corewebspring.model.NickNameList;
import us.tylerrobbins.corewebspring.model.Nickname;
import us.tylerrobbins.corewebspring.model.UserPrivate;
import us.tylerrobbins.corewebspring.model.UserPublic;
import us.tylerrobbins.corewebspring.repository.UserRepository;

@Service
public class UserAccountManagerServiceImpl implements UserAccountManagerService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  RestService restService;


  @Override
  public UserPrivate getPublicAccount(String email) {

    Optional<User> accountOpt = userRepository.findByEmail(email);

    if (accountOpt.isPresent()) {
      User account = accountOpt.get();
      // account.getFname()
      Optional<NickNameList> nickNmaesList = restService.getNickNames(account.getFname());

      // nickname found, return user with nickname
      if (nickNmaesList.isPresent()) {
        List<Nickname> nickNames = nickNmaesList.get().getNicknames();

        return new UserPrivate(account.getEmail(), account.getFname(), account.getLname(),
            nickNames);
      }

      // no nicknames found, return null
      else {
        return new UserPrivate(account.getEmail(), account.getFname(), account.getLname(), null);
      }

      // no user found, return empty object
    } else {
      return new UserPrivate();
    }
  }

  // return full name if login sucecssfull and information about incorrect field if not
  @Override
  public User userLogin(HashMap<String, String> user) {

    Optional<User> account =
        userRepository.findByEmailAndPassword(user.get("email"), user.get("password"));

    if (account.isPresent()) {
      return account.get();

    } else if (userRepository.findByEmail(user.get("email")).isPresent()) {
      return null;

    } else {
      return null;
    }
  }

  // add a user to users table
  @Override
  public String addUser(User user) {

    userRepository.save(user);
    return "Sucessful";
  }

  // search users table for accounts with maching paramaters
  @Override
  public List<User> searchAccounts(Optional<String> firstName, Optional<String> lastName,
      Optional<String> email) {

    // create User and find all examples
    User user = new User();

    if (firstName.isPresent()) {
      user.setFname(firstName.get());
    }
    if (lastName.isPresent()) {
      user.setLname(lastName.get());
    }
    if (email.isPresent()) {
      user.setEmail(email.get());
    }

    // TODO modify to not return password
    return userRepository.findAll(Example.of(user));

  }

  @Override
  public List<UserPublic> getAllUsers() {
    return userRepository.getAllUsersPublic();
  }
}

