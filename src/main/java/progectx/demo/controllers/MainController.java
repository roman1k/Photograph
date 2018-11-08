package progectx.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import progectx.demo.DAO.*;
import progectx.demo.services.PhotographService;
import progectx.demo.services.UserLogService;

@Controller
public class MainController  {
    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private UserLogDAO userLogDao;

    @Autowired
    @Qualifier("userlogServiceImpl")
    private  UserLogService userLogService;

    @Autowired
    @Qualifier("photographServiceImpl")
    private PhotographService photographService;
    @Autowired
    private PasswordEncoder passwordEncoder;

//    @PostMapping("/home")
//    public  String savePhotograph(@RequestParam String role,
//                                  @RequestParam String username,
//                                  @RequestParam String password,
//                                  @RequestParam String mail,
//                                  @RequestParam String name,
//                                  @RequestParam String lastName ){
//
//        if (role.equals("photo")) {
//            photographService.save(photographService.getPhotograph(username,password, mail, name, lastName));
//        }
//         else userLogS
//
//        return "index";
//    }






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
