package us.tylerrobbins.corewebspring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import us.tylerrobbins.corewebspring.model.User;

@RestController
public class LoginController {

  List<User> users = new ArrayList<>();
  {
    users.add(new User("tylerrobbins5678@gmail.com", "tyler", "robbins", "pass"));
  }

  // present user with error instead of "email or password is incorrect"
  @RequestMapping(value = "/account/{email}", method = RequestMethod.GET)
  String userAccount(@PathVariable("email") String email) {

    Optional<String> name =
        users.stream().filter(n -> n.getEmail().equals(email)).map(n -> n.getFname()).findAny();

    if (name.isPresent()) {
      return "welcome to " + name.get() + "'s page";
    } else {
      return "invalid email";
    }
  }

  // user login functionality
  @RequestMapping(value = "/account/login", method = RequestMethod.POST)
  String userlogin(@RequestBody HashMap<String, String> user) {

    Optional<User> account =
        users.stream().filter(n -> n.getEmail().equals(user.get("email"))).findAny();
    if (account.isPresent()) {
      boolean userLogin = account.get().login(user.get("password"));

      if (userLogin) {
        return "Login Sucessful";
      } else {
        return "Invalid Password";
      }

    } else {
      return "Invalid Email";
    }
  }


  // create account
  @RequestMapping(value = "/account", method = RequestMethod.POST)
  String userCreateAccount(@RequestBody User user) {

    users.add(user);
    return "Sucessful";
  }

  // get account matching parameters
  @RequestMapping(value = "/account", method = RequestMethod.GET)
  List<User> userSearchAccount(
      @RequestParam(required = false, name = "fname") Optional<String> fname,
      @RequestParam(required = false, name = "lname") Optional<String> lname,
      @RequestParam(required = false, name = "email") Optional<String> email) {

    // create a stream to pass through filters
    Stream<User> resultStream = users.stream();

    if (fname.isPresent()) {
      resultStream = resultStream.filter(n -> n.getFname().contains(fname.get()));
    }
    if (lname.isPresent()) {
      resultStream = resultStream.filter(n -> n.getLname().contains(lname.get()));
    }
    if (email.isPresent()) {
      resultStream = resultStream.filter(n -> n.getEmail().contains(email.get()));
    }
    return resultStream.collect(Collectors.toList());

  }

  // only return fname and lname
  @RequestMapping(value = "/", method = RequestMethod.GET)
  List<String> showAllUsers() {

    return users.stream().map(User::getFullName).collect(Collectors.toList());
  }
}
