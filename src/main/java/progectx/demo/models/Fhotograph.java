package progectx.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Photograph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;
    private String lastName;
    private  int age;
    private  Sex sex;
    private  Contact contact;
    private  List<Gallary> gallareis;
    private  String describe;
    private int price;
    private Rating rating;
    private  String hashTag;




}
