package progectx.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import progectx.demo.DAO.PhotographDAO;
import progectx.demo.models.Photograph;
import progectx.demo.services.PhotographService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotographServiceImpl implements PhotographService, UserDetailsService {
@Autowired
    private PhotographDAO photographDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return photographDAO.findByUsername(username);
    }


    @Override
    public void save(Photograph photograph) {
        if (photograph!=null){
            photographDAO.save(photograph);
        }
    }


    @Override
    public List<Photograph> findAll() {
        List<Photograph> all = photographDAO.findAll();
        if (all==null){
            return new ArrayList<>();
        }
        return all;
    }


    @Override
    public Photograph findOneById(int id) {
        return null;
    }
}
