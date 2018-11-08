package progectx.demo.services;

import progectx.demo.models.Photograph;

public interface PhotographService {

    void  save(Photograph photograph);
    Photograph getPhotograph(String username, String password, String mail, String name, String lastName);



}
