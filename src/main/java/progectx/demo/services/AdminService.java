package progectx.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import progectx.demo.models.Admin;

import java.util.List;


public interface AdminService {
    void save(Admin admin);


    List<Admin> findAll();


    Admin findOneById(int id);
}
