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

@Data
@Entity
public class Customer extends UserLog implements UserDetails {
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


    //sec
    private boolean accountNonExpired = true;

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }





    private boolean accountNonLocked = true;

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }





    private boolean credentialsNonExpired = true;

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }





    private boolean enabled = true;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.name()));
        return  simpleGrantedAuthorities;
    }

    @Override
    public String getUsername() {
        return nameCustomer;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public Customer(UserLog userLog, String nameCustomer, String lastNameCustomer, int ageCustomer, Contact contact, Role role, Sex sex, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
        this.userLog = userLog;
        this.nameCustomer = nameCustomer;
        this.lastNameCustomer = lastNameCustomer;
        this.ageCustomer = ageCustomer;
        this.contact = contact;
        this.role = role;
        this.sex = sex;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    public Customer(String login, String password, UserLog userLog, String nameCustomer, String lastNameCustomer, int ageCustomer, Contact contact, Role role, Sex sex, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
        super(login, password);
        this.userLog = userLog;
        this.nameCustomer = nameCustomer;
        this.lastNameCustomer = lastNameCustomer;
        this.ageCustomer = ageCustomer;
        this.contact = contact;
        this.role = role;
        this.sex = sex;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }
}

