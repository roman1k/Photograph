package progectx.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import progectx.demo.models.Admin;
import progectx.demo.models.Customer;
import progectx.demo.models.Photograph;
import progectx.demo.models.UserLog;


public interface UserLogService  extends UserDetailsService {
    void  save (UserLog userLog);

    UserLog createCustomer(String username, String password, String mail, String name, String lastName);

//    Photograph getPhotograph(String username, String password, String mail, String name, String lastName);

//    Customer getCustomer(String username, String password, String mail, String name, String lastName);


}
