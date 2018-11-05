package progectx.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import progectx.demo.DAO.AdminDAO;
import progectx.demo.models.Admin;
import progectx.demo.services.AdminService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService,UserDetailsService{

    @Autowired
    private AdminDAO adminDAO;






    @Override
    public void save(Admin admin) {
        if (admin !=null){
            adminDAO.save(admin);

        }

    }



    @Override
    public List<Admin> findAll() {
        List<Admin> all = adminDAO.findAll();
        if (all==null){
            return new ArrayList<>();
        }
        return all;
    }



    @Override
    public Admin findOneById(int id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}

