package progectx.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
   @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private  City city;
    private  String mail;
    private  String facebook;
    private  String instagram;

    public Contact(String number, String mail) {
        this.number = number;
        this.mail = mail;
    }

    public Contact(String mail) {
        this.mail = mail;
    }
}
