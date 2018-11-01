package progectx.demo.services;

import progectx.demo.models.Admin;
import progectx.demo.models.Customer;

import java.util.List;

public interface AdminService {
    void save(Admin admin);

    List<Admin> findAll();

    Admin findOneById(int id);
}
