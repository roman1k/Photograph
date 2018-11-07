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
import progectx.demo.models.*;
import progectx.demo.services.UserLogService;

@Controller
public class MainController  {
    @Autowired
    private PhotographDAO photographDAO;

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

    @PostMapping("/saveKolya")
    public String saveKolya(@RequestParam String username,
                            @RequestParam String password,
                            @RequestParam String number) {
        System.out.println(1);
        Contact contact = new Contact(number);
        System.out.println(2);
        System.out.println(3);
        Kolya kolya = new Kolya(username, password);
        System.out.println(4);
        kolya.setContact(contact);
        System.out.println();
        String encode = passwordEncoder.encode(kolya.getPassword());
        kolya.setPassword(encode);
        userLogService.save(kolya);
        kolya.setContact(contact);
        return "redirect:/index";
    }


    @PostMapping("/photographsettings")
    public String photographsettings(Model model){
        System.out.println("hotographsettings");
        return "PhotographSettings";
    }




    @GetMapping("/login")
    public String login( String type){
        if(type == "U"){

        }
        else{

        }
        System.out.println("login");
        return "login";
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
