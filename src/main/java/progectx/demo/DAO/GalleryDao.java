package progectx.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import progectx.demo.models.Gallery;

public interface GalleryDao extends JpaRepository<Gallery, Integer> {

}
