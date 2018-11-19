package progectx.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import progectx.demo.models.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    UserDetails findByUsername(String username);
}
