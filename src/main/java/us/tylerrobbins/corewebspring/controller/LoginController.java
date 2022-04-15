package us.tylerrobbins.corewebspring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.PathVariable;
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
      return "Hello " + name.get() + " please enter your password";
    } else {
      return "invalid email";
    }
  }

  @RequestMapping(value = "/account/{email}", method = RequestMethod.POST)
  String userlogin(@PathVariable("email") String email, @RequestParam String password) {

    Optional<User> account = users.stream().filter(n -> n.getEmail().equals(email)).findAny();
    if (account.isPresent()) {
      boolean userLogin = account.get().login(password);

      if (userLogin) {
        return "Login Sucessful";
      } else {
        return "Invalid Password";
      }

    } else {
      return "Invalid Email";
    }
  }


  @RequestMapping(value = "/account/create", method = RequestMethod.POST)
  String userCreateAccount(@RequestParam String password, @RequestParam String fname,
      @RequestParam String lname, @RequestParam String email) {

    users.add(new User(email, fname, lname, password));
    return "redirect:/account/" + email;
  }

  @RequestMapping(value = "/account/search", method = RequestMethod.GET)
  List<User> userSearchAccount(@RequestParam(required = false) Optional<String> fname,
      @RequestParam(required = false) Optional<String> lname,
      @RequestParam(required = false) Optional<String> email) {

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
