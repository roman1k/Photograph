package progectx.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Admin extends  UserLog {
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
}


