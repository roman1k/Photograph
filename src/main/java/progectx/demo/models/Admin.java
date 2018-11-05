package progectx.demo.models;

import lombok.AllArgsConstructor;
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
@Data
@EqualsAndHashCode(callSuper = true)
public class Admin extends  UserLog implements UserDetails {
    @Id
    @OneToOne
            (optional = false)
    @JoinColumn(name = "id", unique = true, nullable = false, updatable = false)
    private UserLog userLog;
    private String nameAdmin;
    private Role role = Role.ROLE_Admin;
    @OneToOne(optional = false)
    private Contact contact;

    public Admin(String login, String password) {
        super(login, password);

    }

    public Admin(String login, String password, String nameAdmin, Role role, Contact contact) {
        super(login, password);
        this.nameAdmin = nameAdmin;
        this.role = role;
        this.contact = contact;
    }

    public Admin(String login, String password, Contact contact) {
        super(login, password);
        this.contact = contact;
    }

    public Admin(String login, String password, UserLog userLog, String nameAdmin, Role role) {
        super(login, password);
        this.userLog = userLog;
        this.nameAdmin = nameAdmin;
        this.role = role;
    }
    //sec

    private boolean accountNonExpired = true;

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public String getUsername() {
        return nameAdmin;
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

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "userLog=" + userLog +
                ", nameAdmin='" + nameAdmin + '\'' +
                ", role=" + role +
                ", contact=" + contact +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", enabled=" + enabled +
                '}';
    }
}


