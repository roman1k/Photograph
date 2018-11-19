package progectx.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import progectx.demo.DAO.PhotographDAO;
import progectx.demo.models.*;

import java.util.List;


public interface AdminService {

    //    Адмін:
//1. Видаляти фотографа
//2. Видаляти кастомера
//3. Перегляд усіх фото
//4. Писати лист на пошту
//5. Видалити фото, хештеги
//6. Видалити фото аватарку


   void  DeletePhotograph(String name);

    void  DeleteCustomer(String name);

    List<Photo> ShowAllPhotos();

    String WriteListToEmail(String List);


    void DeleteHashtag(String name);

    void DeletePhotoAvatar(String name);



    void save(Admin admin);


    List<Admin> findAll();


    Admin findOneById(int id);
}
