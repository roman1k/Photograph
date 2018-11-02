package progectx.demo.models;

import lombok.Data;

import javax.persistence.*;

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



}
