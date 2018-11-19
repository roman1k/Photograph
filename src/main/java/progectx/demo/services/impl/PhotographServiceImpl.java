package progectx.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import progectx.demo.DAO.ContactDao;
import progectx.demo.DAO.PhotographDAO;
import progectx.demo.DAO.RatingDAO;
import progectx.demo.models.Contact;
import progectx.demo.models.Photograph;
import progectx.demo.models.Rating;
import progectx.demo.services.PhotographService;

@Service
public class PhotographServiceImpl  implements PhotographService, UserDetailsService {
    @Autowired
    private PhotographDAO photographDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RatingDAO ratingDAO;
    @Autowired
    private ContactDao contactDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  photographDAO.findByUsername(username);
    }

    @Override
    public void save(Photograph photograph) {
            photographDAO.save(photograph);
    }

    @Override
    public Photograph getPhotograph(String username, String password, String mail, String name, String lastName) {
        Rating rating = new Rating();
        ratingDAO.save(rating);
        Contact contact = new Contact(mail);
        contactDao.save(contact);
        Photograph photograph = new Photograph(username,password);
        String encode = passwordEncoder.encode(photograph.getPassword());
        photograph.setPassword(encode);
        photograph.setContact(contact);
        photograph.setRating(rating);
        photograph.setLastName(lastName);
        photograph.setFirstName(name);
        photographDAO.save(photograph);
        return photograph;
    }
}
