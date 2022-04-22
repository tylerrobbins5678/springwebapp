package us.tylerrobbins.corewebspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import us.tylerrobbins.corewebspring.model.User;
import us.tylerrobbins.corewebspring.service.UserAccountManagerService;

@RestController
public class LoginController {

  @Autowired
  private UserAccountManagerService userAccountManager;

  // provide account homepage
  @RequestMapping(value = "/account/{email}", method = RequestMethod.GET)
  String userAccount(@PathVariable("email") String email) {

    return userAccountManager.getPublicAccount(email);
  }

  // user login functionality
  @RequestMapping(value = "/account/login", method = RequestMethod.POST)
  String userlogin(@RequestBody HashMap<String, String> user) {

    return userAccountManager.userLogin(user);
  }


  // create account
  @RequestMapping(value = "/account", method = RequestMethod.POST)
  String userCreateAccount(@RequestBody User user) {

    return userAccountManager.addUser(user);
  }

  // get account matching parameters
  @RequestMapping(value = "/account", method = RequestMethod.GET)
  List<User> userSearchAccount(
      @RequestParam(required = false, name = "fname") Optional<String> fname,
      @RequestParam(required = false, name = "lname") Optional<String> lname,
      @RequestParam(required = false, name = "email") Optional<String> email) {

    return userAccountManager.searchAccounts(fname, lname, email);
  }

  // only return fname and lname
  @RequestMapping(value = "/", method = RequestMethod.GET)
  List<String> showAllUsers() {

    return userAccountManager.getAllUsers();
  }
}
