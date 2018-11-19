package progectx.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import progectx.demo.models.Photograph;
import progectx.demo.models.UserLog;

public interface UserLogDAO extends JpaRepository<UserLog, Integer> {

    UserLog findByUsername(String username);

}
