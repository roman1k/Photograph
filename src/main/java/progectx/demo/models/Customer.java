package progectx.demo.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer extends UserLog {
    @Id
    @OneToOne
            (optional = false)
    @JoinColumn(name="id", unique = true, nullable = false, updatable = false)
    private UserLog userLog;
    private String nameCustomer;
    private String lastNameCustomer;
    private int ageCustomer;
    @OneToOne
            (optional = false)
    @JoinColumn(name="number", unique = true, nullable = false, updatable = false)
    private Contact contact;
    private Role role = Role.ROLE_Customer;
    private Sex sex;









}
