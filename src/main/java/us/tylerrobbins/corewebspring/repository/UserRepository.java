package us.tylerrobbins.corewebspring.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import us.tylerrobbins.corewebspring.entity.User;
import us.tylerrobbins.corewebspring.model.UserPublic;

public interface UserRepository extends JpaRepository<User, Integer> {

  public Optional<User> findByEmail(String email);

  public Optional<User> findByEmailAndPassword(String email, String password);

  @Query(
      value = "SELECT new us.tylerrobbins.corewebspring.model.UserPublic(u.fname, u.lname) FROM User u")
  public List<UserPublic> getAllUsersPublic();
}
