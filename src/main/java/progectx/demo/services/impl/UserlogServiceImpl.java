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

import java.net.URLEncoder;


@Service
public class UserlogServiceImpl implements UserLogService {
    @Autowired
    private  UserLogDAO userLogDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private PhotographDAO photographDAO;

    @Autowired
    private RatingDAO ratingDAO;
    @Autowired
    private ContactDAO contactDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLog byUsername = userLogDAO.findByUsername(username);
        System.out.println(byUsername + " found USER!!!!!!!!!!!");
        return byUsername;
    }

//
//    @Override
//    public void save(Photograph photograph)
//    {
//        photographDAO.save(photograph);
//        System.out.println(5);
//    }
//
//    @Override
//    public void save(Admin admin){
//
//    }
//
//    @Override
//    public void save(Customer customer)
//    {
//        customerDAO.save(customer);
//    }

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
    public void save(UserLog userLog) {
        userLogDAO.save(userLog);
    }

    @Override
    public UserLog  createCustomer(String username, String password, String mail, String name, String lastName) {

        Contact contact = new Contact(mail);
        contactDao.save(contact);
       UserLog userLog = new UserLog(username,password);
        String encode = passwordEncoder.encode(userLog.getPassword());
        userLog.setPassword(encode);
        userLog.setContact(contact);
       userLog.setLastName(lastName);
        userLog.setFirstName(name);
        userLogDAO.save(userLog);
        return userLog;
    }
}
