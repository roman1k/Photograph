package progectx.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import progectx.demo.DAO.ContactDao;
import progectx.demo.DAO.CustomerDAO;
import progectx.demo.DAO.PhotographDAO;
import progectx.demo.DAO.RatingDAO;
import progectx.demo.models.Contact;
import progectx.demo.models.Customer;
import progectx.demo.models.Photograph;
import progectx.demo.models.Rating;
import progectx.demo.services.CustumerServise;

@Service
public class CustumerServiseImpl implements CustumerServise, UserDetailsService {
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ContactDao contactDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
    }
