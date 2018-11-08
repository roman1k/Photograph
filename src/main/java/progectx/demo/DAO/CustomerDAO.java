package progectx.demo.DAO;

import jdk.nashorn.internal.objects.annotations.SpecializedFunction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.security.core.userdetails.UserDetails;
import progectx.demo.models.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> , JpaSpecificationExecutor<Customer>{




}
