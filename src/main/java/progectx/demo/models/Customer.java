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

    public Customer(String login, String password, UserLog userLog, String nameCustomer, String lastNameCustomer, Contact contact) {
        super(login, password);
        this.userLog = userLog;
        this.nameCustomer = nameCustomer;
        this.lastNameCustomer = lastNameCustomer;
        this.contact = contact;
    }

    public Customer(String login, String password, String nameCustomer, String lastNameCustomer, int ageCustomer, Contact contact, Sex sex) {
        super(login, password);
        this.nameCustomer = nameCustomer;
        this.lastNameCustomer = lastNameCustomer;
        this.ageCustomer = ageCustomer;
        this.contact = contact;
        this.sex = sex;
    }

    public Customer(String login, String password, UserLog userLog) {
        super(login, password);
        this.userLog = userLog;
    }
}
