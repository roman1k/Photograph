package progectx.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import progectx.demo.DAO.AdminDAO;
import progectx.demo.DAO.CustomerDAO;
import progectx.demo.DAO.GalleryDao;
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
//5. Видалити фото

    @Autowired
    private GalleryDao galleryDao;

    @Autowired
    private AdminDAO adminDAO;


    @Autowired
    private PhotographDAO photographDAO;

@Autowired
private CustomerDAO customerDAO;

    //1. Видаляти фотографа
    @Override
    public Object DeletePhotograph(String name) {
        Stream<Photograph> allPhotographs = photographDAO.findAll().stream();
        List<Photograph> Photograph = allPhotographs.filter(photograph1 -> photograph1.getUsername().equals(name)).collect(Collectors.toList());
        return  Photograph.remove(0);
    }


    //2. Видаляти кастомера
    @Override
    public Object DeleteCustomer(String name) {
        Stream<Customer> allCustomers = customerDAO.findAll().stream();
        List<Customer> Customer = allCustomers.filter(customer -> customer.getUsername().equals(name)).collect(Collectors.toList());
        return  Customer.remove(0);
    }
    //3. Перегляд усіх фото
    @Override
    public List<Photo> ShowAllPhotos() {
        List<Photograph> AllPhotographs = photographDAO.findAll().stream().collect(Collectors.toList());
       List<List<Gallery>>AllGalleries = new ArrayList<>();
        List<Photo>AllPhotos = new ArrayList<>();
        for (Photograph photograph:AllPhotographs) {
            List<Gallery> galleries = photograph.getGalleries();
            for (Gallery gallerie : galleries) {
                List<Photo> photos = gallerie.getPhotos();
                for (Photo photo : photos) {
                    AllPhotos.add(photo);
                }

            }

            AllGalleries.add(galleries);

        }
        return AllPhotos;
    }

    //4. Писати лист на пошту
    @Override
    public String WriteListToEmail(String List) {

        return null;
    }



    //6. Видалити  хештеги ???????????????????????????
    @Override
    public void DeleteHashtag(String name) {
        List<Gallery> galleries = galleryDao.findAll();
        List<Gallery> collect = galleries.stream().filter(gallery -> gallery.getHashTag().equals(name)).collect(Collectors.toList());
        Gallery gallery = collect.get(0);
        gallery.setHashTag(null);
        galleryDao.save(gallery);
    }
    //7. Видалити фото аватарку
    @Override
    public void DeletePhotoAvatar(String name) {
        List<Photograph> all = photographDAO.findAll();
        Stream<Photograph> photographStream = all.stream().filter(photograph -> photograph.getUsername().equals(name));
        List<Photograph> photographsWhoHasThisAvatar = photographStream.collect(Collectors.toList());
        Photograph photograph = photographsWhoHasThisAvatar.get(0);
        photograph.setAvatar(null);
        photographDAO.save(photograph);}


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

