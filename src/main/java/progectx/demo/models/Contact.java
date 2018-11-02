package progectx.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Data
public class Contact {
    @Id
    private String number;
    @ManyToOne
    private  City city;
    private  String mail;
    private  String facebook;
    private  String instagram;
//    @OneToOne
//            (optional = false, mappedBy="Photograph")
//    public Photograph photograph;

}
