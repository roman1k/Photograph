package progectx.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import progectx.demo.DAO.CustomerDAO;
import progectx.demo.DAO.PhotographDAO;
import progectx.demo.models.Customer;
import progectx.demo.models.Photograph;
import progectx.demo.services.CustomerService;

@Controller
public class MainController  {



    @Autowired
    private CustomerDAO customerDAO;



    @Autowired
    PhotographDAO photographDAO;



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





    @PostMapping("/saveCustomer")
    public String saveCustomer(Customer customer){



        customerDAO.save(customer);
        return "login";
    }



    @PostMapping("/savePhotographer")
    public String savePhotographer(Photograph photograph){
        photographDAO.save(photograph);
        return "login";
    }





}
