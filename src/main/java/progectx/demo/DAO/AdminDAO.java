package progectx.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import progectx.demo.models.Admin;

public interface AdminDAO  extends JpaRepository<Admin, Integer> {

}
