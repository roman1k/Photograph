package progectx.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import progectx.demo.DAO.PhotographDAO;
import progectx.demo.models.Photograph;

import java.util.List;

@RestController
public class PhotographRestController {

    @Autowired
    private PhotographDAO photographDAO;



}
