package progectx.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import progectx.demo.models.Photograph;

import java.util.List;

public interface PhotographService  extends UserDetailsService {

    void save(Photograph user);

    List<Photograph> findAll();

    Photograph findOneById(int id);
}

