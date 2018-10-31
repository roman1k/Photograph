package progectx.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import progectx.demo.models.Customer;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

}
