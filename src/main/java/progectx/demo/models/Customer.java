package progectx.demo.models;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
public class Customer  extends UserLog {
    @OneToOne(optional = false)
    @JoinColumn(name = "id", unique = true, nullable = false, updatable = false)
    private  UserLog userLog;
    private Role role = Role.ROLE_Customer;


    public Customer(String username, String password) {
        super(username, password);
    }

    public Customer(String username, String password, String firstName, String lastName, Contact contact) {
        super(username, password, firstName, lastName, contact);
    }
}

