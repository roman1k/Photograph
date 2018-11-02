package progectx.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String namePhoto;
    @ManyToOne
    private  Gallary gallary;

}
