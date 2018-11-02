package progectx.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import progectx.demo.DAO.AdminDAO;
import progectx.demo.DAO.CustomerDAO;
import progectx.demo.DAO.PhotographDAO;

@Controller
public class MainController  {

    @Autowired
    private PhotographDAO photographDAO;

    @Autowired
    private  AdminDAO adminDAO;


    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/")
    public String index(Model model){
        System.out.println("home");
        return "index";
    }

    @PostMapping("/photographsettings")
    public String photographsettings(Model model){
        System.out.println("hotographsettings");
        return "PhotographSettings";
    }

    @GetMapping("/login")
    public String login(Model model)
    {
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

    @PostMapping("/successURL")
    public String successURL() {

        return "index";
    }

    @PostMapping("/uploadPhoto")
    public  void uploadPhoto(){

    }



}
