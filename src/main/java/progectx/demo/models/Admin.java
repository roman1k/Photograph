package progectx.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Admin extends  UserLog {
    @Id
    @OneToOne
            (optional = false)
    @JoinColumn(name="id", unique = true, nullable = false, updatable = false)
    private UserLog userLog;
    private  String nameAdmin;
    private Role role = Role.ROLE_Admin;
    @OneToOne(optional = false)
    private Contact contact;

}
