package progectx.demo.models;




import javax.persistence.*;


@Entity
public class Admin  extends UserLog {
    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "id", unique = true, nullable = false, updatable = false)
    private int id;
    Role role = Role.ROLE_Admin;

    public Admin(String username, String password) {
        super(username, password);
    }

    public Admin(String username, String password, String firstName, String lastName, Contact contact) {
        super(username, password, firstName, lastName,  contact);
    }


}





