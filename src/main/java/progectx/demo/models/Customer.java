package progectx.demo.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer extends UserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String nameCustomer;
    private String lastNameCustomer;
    private int ageCustomer;
    @OneToOne
            (optional = false)
    @JoinColumn(name="number", unique = true, nullable = false, updatable = false)
    private Contact contact;









}
