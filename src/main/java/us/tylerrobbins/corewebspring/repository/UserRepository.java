package us.tylerrobbins.corewebspring.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import us.tylerrobbins.corewebspring.model.User;
import us.tylerrobbins.corewebspring.model.UserPublic;

public interface UserRepository extends JpaRepository<User, Integer> {

  public Optional<User> findByEmail(String email);

  public Optional<User> findByEmailAndPassword(String email, String password);

  @Query(
      value = "SELECT new us.tylerrobbins.corewebspring.model.UserPublic(u.fname as firstName, u.lname as lastName) FROM User u")
  public List<UserPublic> getAllUsers();
}
