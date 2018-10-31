package progectx.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Photograph extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String name;
    private  String lastName;
    private  int age;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private  Sex sex;
    private  Contact contact;
    private  List<Gallary> gallareis;
    private  String describe;
    private  int price;
    private  Rating rating;
    private  String hashTag;
}

