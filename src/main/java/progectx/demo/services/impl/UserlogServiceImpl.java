package progectx.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import progectx.demo.DAO.*;
import progectx.demo.models.*;

import progectx.demo.services.UserLogService;



@Service
public class UserlogServiceImpl implements UserLogService, UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userLogDao.findByUsername(username);
    }
    @Autowired
    private UserLogDao userLogDao;
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private PhotographDAO photographDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RatingDAO ratingDAO;
    @Autowired
    private ContactDao contactDao;


    @Override
    public void save(Photograph photograph)
    {
        photographDAO.save(photograph);
        System.out.println(5);
    }

    @Override
    public void save(Admin admin){

    }

    @Override
    public void save(Customer customer)
    {
        customerDAO.save(customer);
    }

//    @Override
//    public Photograph getPhotograph(String username, String password, String mail, String name, String lastName){
//        Rating rating = new Rating();
//        ratingDAO.save(rating);
//        Contact contact = new Contact(mail);
//        contactDao.save(contact);
//        Photograph photograph = new Photograph(username,password);
//        String encode = passwordEncoder.encode(photograph.getPassword());
//        photograph.setPassword(encode);
//        photograph.setContact(contact);
//        photograph.setRating(rating);
//        photograph.setLastName(lastName);
//        photograph.setFirstName(name);
//        photographDAO.save(photograph);
//        return photograph;
//    }

    @Override
    public Customer getCustomer(String username, String password, String mail, String name, String lastName) {
        Customer customer = new Customer(username,password);
        customerDAO.save(customer);
        String encode = passwordEncoder.encode(customer.getPassword());
        Contact contact = new Contact(mail);
        customer.setPassword(encode);
        customer.setContact(contact);
        return customer;
    }
}
