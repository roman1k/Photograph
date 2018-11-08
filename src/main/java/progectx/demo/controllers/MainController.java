package progectx.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import progectx.demo.DAO.*;
import progectx.demo.models.*;
import progectx.demo.services.UserLogService;

@Controller
public class MainController  {
    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private UserLogDao  userLogDao;

    @Autowired
    @Qualifier("userlogServiceImpl")
    private  UserLogService userLogService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/home")
    public  String savePhotograph(@RequestParam String role,
                                  @RequestParam String username,
                                  @RequestParam String password,
                                  @RequestParam String mail,
                                  @RequestParam String name,
                                  @RequestParam String lastName ){

        if (role.equals("photo")) {
            userLogService.save(userLogService.getPhotograph(username,password, mail, name, lastName));
        }
        else{
            userLogService.save(userLogService.getCustomer(username,password, mail, name, lastName));
        }
        return "index";
    }






    @PostMapping("/photographsettings")
    public String photographsettings(Model model){
        System.out.println("hotographsettings");
        return "PhotographSettings";
    }






    @GetMapping("/main")
    public String main(Model model){
        System.out.println("main");
        return "main";
    }
    @GetMapping("/photographprofile")
    public  String photographprofile(Model model){
        System.out.println("profile");
        return "PhotographProfie";
    }





}
