package progectx.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import progectx.demo.DAO.AdminDAO;
import progectx.demo.DAO.CustomerDAO;
import progectx.demo.DAO.PhotographDAO;
import progectx.demo.models.*;
import progectx.demo.services.AdminService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AdminServiceImpl implements AdminService,UserDetailsService{


    @Autowired
    private AdminDAO adminDAO;


    @Autowired
    private PhotographDAO photographDAO;

@Autowired
private CustomerDAO customerDAO;


    @Override
    public Object DeletePhotograph(String name) {
        Stream<Photograph> allPhotographs = photographDAO.findAll().stream();
        List<Photograph> Photograph = allPhotographs.filter(photograph1 -> photograph1.getNamePhotograph().equals(name)).collect(Collectors.toList());
        return  Photograph.remove(0);
    }



    @Override
    public Object DeleteCustomer(String name) {
        Stream<Customer> allCustomers = customerDAO.findAll().stream();
        List<Customer> Customer = allCustomers.filter(customer -> customer.getNameCustomer().equals(name)).collect(Collectors.toList());
        return  Customer.remove(0);
    }

    @Override
    public List<Gallery> ShowAllPhotos() {
        List<Photograph> AllPhotographs = photographDAO.findAll().stream().collect(Collectors.toList());
       List<List<Gallery>>AllGalleries = new ArrayList<>();
        for (Photograph photograph:AllPhotographs) {
            List<Gallery> galleries = photograph.getGalleries();
            AllGalleries.add(galleries);

        }
        return null;
    }

    @Override
    public String VriteListToEmail(String List) {
        return null;
    }

    @Override
    public String DeletePhoto(Gallery gallery) {
        return null;
    }

    @Override
    public String DeleteHashtag(Gallery gallery) {
        return null;
    }

    @Override
    public String DeletePhotoAvatar(Gallery gallery) {
        return null;
    }

    @Override
    public void save(Admin admin) {
        if (admin !=null){
            adminDAO.save(admin);

        }

    }



    @Override
    public List<Admin> findAll() {
        List<Admin> all = adminDAO.findAll();
        if (all==null){
            return new ArrayList<>();
        }
        return all;
    }



    @Override
    public Admin findOneById(int id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

}

