package progectx.demo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Data
@Entity
@Table(name = "photograph")
public class Photograph  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String login;
    private  String password;
    private String namePhotograph;
    private  String lastNamePhotograph;
    private  int agePhotograph;
    private  int price;
    @OneToOne
          (optional = false)
    @JoinColumn(name="number", unique = true, nullable = false, updatable = false)
    private Contact contact;
    @OneToMany
    private List<Gallery> galleries;
    private Role role = Role.ROLE_Photograph;
    @OneToOne
    private Rating rating;
    private Sex sex;
    private String avatar;
    private String hashTag;
    private String describe;



    ///sec
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.name()));
        return  simpleGrantedAuthorities;
    }

    @Override
    public String getUsername() {
        return namePhotograph;
    }

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


    public Photograph( String namePhotograph, String lastNamePhotograph, int agePhotograph, int price, Contact contact, List<Gallery> galleries, Role role, Rating rating, Sex sex, String avatar, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled, String describe) {
        this.namePhotograph = namePhotograph;
        this.lastNamePhotograph = lastNamePhotograph;
        this.agePhotograph = agePhotograph;
        this.price = price;
        this.contact = contact;
        this.galleries = galleries;
        this.role = role;
        this.rating = rating;
        this.sex = sex;
        this.avatar = avatar;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.describe = describe;
    }

    public Photograph(String login, String password,  String namePhotograph, String lastNamePhotograph, int agePhotograph, int price, Contact contact, List<Gallery> galleries, Role role, Rating rating, Sex sex, String avatar, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled, String describe) {
        this.password = password;
        this.login = login;
        this.namePhotograph = namePhotograph;
        this.lastNamePhotograph = lastNamePhotograph;
        this.agePhotograph = agePhotograph;
        this.price = price;
        this.contact = contact;
        this.galleries = galleries;
        this.role = role;
        this.rating = rating;
        this.sex = sex;
        this.avatar = avatar;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.describe = describe;
    }
    public Photograph(String namePhotograph,String lastNamePhotograph,int agePhotograph,Sex sex,Contact contact,String describe,int price, String hashTag){
        this.namePhotograph = namePhotograph;
        this.lastNamePhotograph = lastNamePhotograph;
        this.agePhotograph = agePhotograph;
        this.sex = sex;
        this.contact = contact;
        this.describe = describe;
        this.price = price;
        this.hashTag = hashTag;
    }
}


