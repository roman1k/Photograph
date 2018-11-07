package progectx.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import progectx.demo.models.Admin;
import progectx.demo.models.Customer;
import progectx.demo.models.Gallery;
import progectx.demo.models.Photograph;

import java.util.List;


public interface AdminService {

    //    Адмін:
//1. Видаляти фотографа
//2. Видаляти кастомера
//3. Перегляд усіх фото
//4. Писати лист на пошту
//5. Видалити фото, хештеги
//6. Видалити фото аватарку


    Object DeletePhotograph(String name);

    Object DeleteCustomer(String name);

    List<Gallery> ShowAllPhotos();

    String VriteListToEmail(String List);

    String DeletePhoto(Gallery gallery);

    String DeleteHashtag(Gallery gallery);

    String DeletePhotoAvatar(Gallery gallery);



    void save(Admin admin);


    List<Admin> findAll();


    Admin findOneById(int id);
}
