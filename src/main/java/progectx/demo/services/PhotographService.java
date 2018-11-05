package progectx.demo.services;


import progectx.demo.models.Photograph;

import java.util.List;

public interface PhotographService {

    void save(Photograph user);


    List<Photograph> findAll();

    Photograph findOneById(int id);
}

