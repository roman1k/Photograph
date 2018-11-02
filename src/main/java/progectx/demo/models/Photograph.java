package progectx.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Photograph extends UserLog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String namePhotograph;
    private  String lastNamePhotograph;
    private  int age;
    private  int price;
    private  String description;
    @OneToOne
    private Contact contact;
    @OneToMany
    private List<Gallary> gallaries;
    private Role role = Role.ROLE_Photograph;
    @OneToOne
    private Rating rating;
    private Sex sex;


    }


