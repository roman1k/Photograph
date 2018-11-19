package progectx.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import progectx.demo.DAO.*;
import progectx.demo.models.*;
import progectx.demo.services.AdminService;
import progectx.demo.services.CustumerServise;
import progectx.demo.services.PhotographService;
import progectx.demo.services.UserLogService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController  {
    @Autowired
    private CityDao cityDao;
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private PhotographDAO photographDAO;
    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private UserLogDao  userLogDao;

    @Autowired
    @Qualifier("userlogServiceImpl")
    private  UserLogService userLogService;

    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminService adminService;
    @Autowired
    @Qualifier("custumerServiseImpl")
    private CustumerServise custumerServise;
    @Autowired
    @Qualifier("photographServiceImpl")
    private PhotographService photographService;
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
            photographService.save(photographService.getPhotograph(username,password, mail, name, lastName));
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



    //admin delete user
    @PostMapping("/a")
    public String a(@RequestParam String name){
        adminService.DeletePhotograph(name);
        return "kolya";
    }
    //admin delete customer
    @PostMapping("/b")
    public String b(@RequestParam String name){
        adminService.DeleteCustomer(name);
        return "kolya";
    }
//this User
    @GetMapping("/userFound")
    public String findUser(@RequestParam  String username,Model model){

        List<Object> thiss = new ArrayList<>();
        List<Customer> customersAll = customerDAO.findAll();
        List<Customer> thiscustomer = customersAll.stream().filter(customer -> customer.getUsername().equals(username)).collect(Collectors.toList());
        List<Photograph> photographsAll = photographDAO.findAll();
        List<Photograph> thisphotograph = photographsAll.stream().filter(photograph -> photograph.getUsername().equals(username)).collect(Collectors.toList());
        if (thiscustomer.size() > 0) {
            Customer customer = thiscustomer.get(0);
            thiss.add(customer);
        } else {
            Photograph photograph = thisphotograph.get(0);
            thiss.add(photograph);
        }
        Object o = thiss.get(0);
        model.addAttribute("o",o);
        return "admin";}



    @GetMapping("/admin")
    public String ab(){
        return "admin";
    }


@GetMapping("/allCities")
public String allCities(Model model){
    List<City> cities = cityDao.findAll();
    model.addAttribute("cities",cities);
    return "admin";
}
@GetMapping("/saveCity")
    public String saveCity(@RequestParam ("nameCity")String name ){
        City city = new City(name);
        cityDao.save(city);
        return "admin";
    }

}

