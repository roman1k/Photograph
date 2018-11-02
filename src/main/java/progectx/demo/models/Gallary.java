package progectx.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Gallary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String nameGallary;
    private String hashTag;
    @OneToMany
    private List<Photo> photos;


}
