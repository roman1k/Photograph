package progectx.demo.services;

import org.springframework.stereotype.Service;
import progectx.demo.models.Admin;
import progectx.demo.models.Customer;
import progectx.demo.models.Photograph;
import progectx.demo.models.UserLog;


public interface UserLogService  {

    void  save(Photograph photograph);
    void  save(Admin admin);
    void  save (Customer customer);

    Photograph getPhotograph(String username, String password, String mail, String name, String lastName);

    Customer getCustomer(String username, String password, String mail, String name, String lastName);


}
