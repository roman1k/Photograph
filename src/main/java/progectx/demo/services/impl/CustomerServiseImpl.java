package progectx.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import progectx.demo.DAO.CustomerDAO;
import progectx.demo.DAO.PhotographDAO;
import progectx.demo.DAO.RatingDAO;
import progectx.demo.models.Contact;
import progectx.demo.models.Customer;
import progectx.demo.models.Photograph;
import progectx.demo.models.Rating;
import progectx.demo.services.CustomerServise;

import java.util.List;

@Service
public class CustomerServiseImpl implements CustomerServise, UserDetailsService {
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PhotographDAO photographDAO;
    @Autowired
    private RatingDAO ratingDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerDAO.findByUsername(username);
    }

    @Override
    public void save(Customer customer) {
        customerDAO.save(customer);

    }

    @Override
    public Customer createCustomer(String username, String password, String mail, String name, String lastName) {
        Customer customer = new Customer(username,password);
        customerDAO.save(customer);
        String encode = passwordEncoder.encode(customer.getPassword());
        Contact contact = new Contact(mail);
        customer.setPassword(encode);
        customer.setContact(contact);
        return customer;
    }




}

