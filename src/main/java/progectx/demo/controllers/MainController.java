package progectx.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import progectx.demo.DAO.*;
import progectx.demo.models.Customer;
import progectx.demo.models.Photograph;
import progectx.demo.models.UserLog;
import progectx.demo.services.CustomerServise;
import progectx.demo.services.PhotographService;
import progectx.demo.services.UserLogService;
import progectx.demo.services.impl.AdminServiceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController  {

    @Qualifier("userlogServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private UserLogDAO userLogDao;
    @Autowired
    private PhotographDAO photographDAO;

    @Autowired
    @Qualifier("userlogServiceImpl")
    private  UserLogService userLogService;

    @Autowired
    @Qualifier("photographServiceImpl")
    private PhotographService photographService;
    @Autowired
    @Qualifier("customerServiseImpl")
    private CustomerServise customerServise;
    @Autowired
    private PasswordEncoder passwordEncoder;

//    @GetMapping("/login")
//    private String  login ( Model model){
//        if (type.equals("photo")) model.addAttribute( "user","Photograph");
//
//
//        return  "login";
//    }

    @PostMapping("/saveUserLog")
    private  String saveUser(
                             @RequestParam String fistName,
                             @RequestParam String lastName,
                             @RequestParam String email,
                             @RequestParam String username,
                             @RequestParam String password
                            ){
      /*  if(type.equals("Photograph"))
        { photographService.save(photographService.getPhotograph(username,password, email, fistName, lastName));}
        else {*/
            userLogService.save(userLogService.createCustomer(username, password, email, fistName, lastName));
//            customerServise.save(customerServise.createCustomer(username, password, email, fistName, lastName));
//        }
        return "index";

    }
    @PostMapping("/successURL")
    private  String saveUser( ) {

        return "index";
//        CustomerProfile.html
    }

    @GetMapping("/userFound")
    public String findUser(@RequestParam  String username,Model model){
        System.out.println(userLogService.loadUserByUsername(username));

        if (customerDAO.findByUsername(username)!=null){
            Customer customer = customerDAO.findByUsername(username);
            model.addAttribute("thiss",customer);
        }
        else {if(photographDAO.findByUsername(username)!=null) {
            Photograph customer = photographDAO.findByUsername(username);
            model.addAttribute("thiss",customer);
        }
        else {

            System.out.println(1);
            if (userDetailsService.loadUserByUsername(username) != null) {
                UserDetails userLog = userLogDao.findByUsername(username);
             model.addAttribute("thiss", userLog);
            }
        }}


   /*     List<Object> thiss = new ArrayList<>();
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
        thiss.get(0);*/
        return "CustomerProfile";}

        @GetMapping("/CustomerProfile")
        public  void aVoid(){

        }









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
