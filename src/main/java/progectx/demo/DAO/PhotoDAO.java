package progectx.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import progectx.demo.models.Photo;

public interface PhotoDAO extends JpaRepository<Photo, Integer> {
}
