package progectx.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "photograph")
public class Photograph extends UserLog{
    @Id
    @OneToOne
            (optional = false)
    @JoinColumn(name="id", unique = true, nullable = false, updatable = false)
    private UserLog userLog;
    private String namePhotograph;
    private  String lastNamePhotograph;
    private  int agePhotograph;
    private  int price;
    private  String descriptionPhotograph;
    @OneToOne
          (optional = false)
    @JoinColumn(name="number", unique = true, nullable = false, updatable = false)
    private Contact contact;
    @OneToMany
    private List<Gallary> gallaries;
    private Role role = Role.ROLE_Photograph;
    @OneToOne
    private Rating rating;
    private Sex sex;
    private String avatar;


    }


