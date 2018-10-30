package progectx.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import progectx.demo.models.Photograph;

public interface PhotographDAO extends JpaRepository<Photograph,Integer> {

}
