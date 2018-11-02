package progectx.demo.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Customer extends UserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idCustomer;
    private String nameCustomer;
    private String lastName;
    private int age;








}
