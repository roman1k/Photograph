package progectx.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import progectx.demo.DAO.CustomerDAO;
import progectx.demo.DAO.PhotographDAO;
import progectx.demo.models.Contact;
import progectx.demo.models.Customer;
import progectx.demo.models.Photograph;
import progectx.demo.models.Sex;

@Controller
public class MainController  {



    @Autowired
    private CustomerDAO customerDAO;

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Autowired
    PhotographDAO photographDAO;



    @GetMapping("/")
    public String index(Model model){
        System.out.println("home");
        return "index";
    }


    @PostMapping("/photographsettings")
    public String photographsettings(Model model){

        return "PhotographSettings";
    }




    @GetMapping("/login/{Photograph}")
    public String loginPhotograph(
            Model model
    ){
        return "login";
    }


    @GetMapping("/login/{Costumer}")
    public String loginCostumer(
            Model model
    ){
        return "login";
    }


    //Виконуємо вхід на сайт
    // Доробити первірку на пароль і логін
    @PostMapping("/login/sign-in")
    public String LoginSignIn(
            @RequestParam String login,
            @RequestParam String password
    ){

        return "main";
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


    @PostMapping("/uploadPhotograph")
    public String uploadPhotograph(
        @RequestParam MultipartFile profileImage,
        @RequestParam String namePhotograph,
        @RequestParam String lastNamePhotograph,
        @RequestParam int agePhotograph,
        @RequestParam Sex sex,
        @RequestParam Contact contact,

        @RequestParam String describe,
        @RequestParam int price,
        @RequestParam String hashTag
        ){
        Photograph photograph = new Photograph(namePhotograph,lastNamePhotograph, agePhotograph,sex,contact,describe,price,hashTag);
        photograph.setAvatar(profileImage.getOriginalFilename());
        photographDAO.save(photograph);
        return "main";


    }

}
