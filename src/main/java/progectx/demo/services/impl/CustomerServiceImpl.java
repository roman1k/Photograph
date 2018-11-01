package progectx.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import progectx.demo.DAO.CustomerDAO;
import progectx.demo.models.Customer;
import progectx.demo.services.CustomerService;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService,UserDetailsService {
   @Autowired
   private CustomerDAO customerDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerDAO.findByUsername(username);
    }



    @Override
    public void save(Customer customer) {
        if (customer != null) {
            customerDAO.save(customer);
        }
    }

        @Override
        public List<Customer> findAll() {
            List<Customer> all = customerDAO.findAll();
            if (all==null){
                return new ArrayList<>();
            }
            return all;
        }


        @Override
    public Customer findOneById(int id) {
        return null;
    }
}
