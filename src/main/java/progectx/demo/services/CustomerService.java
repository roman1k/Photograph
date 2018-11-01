package progectx.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import progectx.demo.models.Customer;

import java.util.List;

public interface CustomerService extends UserDetailsService {

    void save(Customer user);

    List<Customer> findAll();

    Customer findOneById(int id);
}

