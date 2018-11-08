package progectx.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import progectx.demo.models.Rating;

public interface RatingDAO  extends JpaRepository<Rating, Integer> {

}
