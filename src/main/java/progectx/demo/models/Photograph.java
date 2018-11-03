package progectx.demo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;
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
    @OneToOne
          (optional = false)
    @JoinColumn(name="number", unique = true, nullable = false, updatable = false)
    private Contact contact;
    @OneToMany
    private List<Gallery> galleries;
    private Role role = Role.ROLE_Photograph;
    @OneToOne
    private Rating rating;
    private Sex sex;
    private String avatar;
    public Photograph(String login, String password, String namePhotograph, String lastNamePhotograph, Contact contact) {
        super(login, password);
        this.namePhotograph = namePhotograph;
        this.lastNamePhotograph = lastNamePhotograph;
        this.contact = contact;
    }

    public Photograph(String login, String password, String namePhotograph, String lastNamePhotograph, int agePhotograph,  int price, Contact contact, List<Gallery> galleries, Rating rating, Sex sex, String avatar) {
        super(login, password);
        this.namePhotograph = namePhotograph;
        this.lastNamePhotograph = lastNamePhotograph;
        this.agePhotograph = agePhotograph;
        this.price = price;
        this.contact = contact;
        this.galleries = galleries;
        this.rating = rating;
        this.sex = sex;
        this.avatar = avatar;
    }

    public Photograph(String login, String password, String namePhotograph, String lastNamePhotograph, int agePhotograph, int price, Contact contact, List<Gallery> galleries) {
        super(login, password);
        this.namePhotograph = namePhotograph;
        this.lastNamePhotograph = lastNamePhotograph;
        this.agePhotograph = agePhotograph;
        this.price = price;
        this.contact = contact;
        this.galleries = galleries;
    }

    public Photograph(String login, String password, String namePhotograph, String lastNamePhotograph, int agePhotograph, Contact contact) {
        super(login, password);
        this.namePhotograph = namePhotograph;
        this.lastNamePhotograph = lastNamePhotograph;
        this.agePhotograph = agePhotograph;
        this.contact = contact;
    }

    public Photograph(String login, String password, String namePhotograph, String lastNamePhotograph, Contact contact, List<Gallery> galleries, Rating rating, Sex sex, String avatar) {
        super(login, password);
        this.namePhotograph = namePhotograph;
        this.lastNamePhotograph = lastNamePhotograph;
        this.contact = contact;
        this.galleries = galleries;
        this.rating = rating;
        this.sex = sex;
        this.avatar = avatar;
    }

    public Photograph(String login, String password, String namePhotograph, String lastNamePhotograph, int agePhotograph, int price, Contact contact, List<Gallery> galleries, Rating rating, Sex sex) {
        super(login, password);
        this.namePhotograph = namePhotograph;
        this.lastNamePhotograph = lastNamePhotograph;
        this.agePhotograph = agePhotograph;
        this.price = price;
        this.contact = contact;
        this.galleries = galleries;
        this.rating = rating;
        this.sex = sex;
    }
}


