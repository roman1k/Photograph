package progectx.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
@Table(name = "contact")
public class Contact {
    @Id
    @Column (name="number")
    private String number;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private  City city;
    private  String mail;
    private  String facebook;
    private  String instagram;
   @OneToOne
           (optional = false, mappedBy="contact")
   public Photograph photograph;
    @OneToOne
            (optional = false, mappedBy="contact")
    public Admin admin;
    @OneToOne
            (optional = false, mappedBy="contact")
    public Customer customer;

    public Contact(String number, City city, String mail, String facebook, String instagram) {
        this.number = number;
        this.city = city;
        this.mail = mail;
        this.facebook = facebook;
        this.instagram = instagram;
    }

    public Contact(String number, City city, String mail) {
        this.number = number;
        this.city = city;
        this.mail = mail;
    }

    public Contact(String number, String mail, String facebook, String instagram) {
        this.number = number;
        this.mail = mail;
        this.facebook = facebook;
        this.instagram = instagram;
    }

    public Contact(String number, String mail, String facebook) {
        this.number = number;
        this.mail = mail;
        this.facebook = facebook;
    }


}
