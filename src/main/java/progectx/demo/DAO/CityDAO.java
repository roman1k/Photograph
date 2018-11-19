package progectx.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import progectx.demo.models.City;

public interface CityDAO extends JpaRepository<City, Integer> {
}
