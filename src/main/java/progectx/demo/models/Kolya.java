package progectx.demo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Entity

public class Kolya  extends UserLog {
    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "id", unique = true, nullable = false, updatable = false)
    private UserLog userLog;
    private Role role = Role.ROLE_Customer;


    public Kolya(String username, String password) {
        super(username, password);
    }
}


