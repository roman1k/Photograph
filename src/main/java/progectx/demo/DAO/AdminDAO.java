package progectx.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import progectx.demo.models.Admin;
import progectx.demo.models.Customer;
import progectx.demo.models.Gallery;
import progectx.demo.models.Photograph;

import java.util.List;

public interface AdminDAO  extends JpaRepository<Admin, Integer> {


}
