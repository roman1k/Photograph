package progectx.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

}
