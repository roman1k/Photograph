package progectx.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import progectx.demo.DAO.PhotographDAO;
import progectx.demo.models.Photograph;

@Controller
public class MainController  {

    @Autowired
    private PhotographDAO photographDAO;

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
    public String login(Model model){
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

    @PostMapping("/successURL")
    public String successURL() {

        return "index";
    }







}
