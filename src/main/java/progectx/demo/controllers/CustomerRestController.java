package progectx.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import progectx.demo.DAO.CustomerDAO;
import progectx.demo.models.UserLog;
import progectx.demo.services.CustomerServise;

@RestController
@Controller
public class CustomerRestController {
    @Autowired
   private CustomerDAO customerDAO;

    @Autowired
    @Qualifier("customerServiseImpl")
    private CustomerServise customerServise;

    @GetMapping("/CustomerProfile/{username}")
    public String CustomerProfile(@PathVariable String username, @AuthenticationPrincipal UserDetails userDetails){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserLog userLog = (UserLog)authentication.getPrincipal();


        return "CustomerProfile";
    }







}
