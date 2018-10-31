package progectx.demo.service.impl.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import progectx.demo.DAO.PhotographDAO;
import progectx.demo.models.Photograph;
import progectx.demo.service.impl.PhotographService;

public class PhotographServiceImp implements PhotographService {

    @Autowired
    private PhotographDAO photographDAO;

}
