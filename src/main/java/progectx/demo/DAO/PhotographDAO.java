package progectx.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import progectx.demo.models.Photograph;

public interface PhotographDAO extends JpaRepository<Photograph,Integer> {




}
