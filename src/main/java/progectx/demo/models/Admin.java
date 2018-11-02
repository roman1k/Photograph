package progectx.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Admin extends  UserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String nameAdmin;
//    @ManyToOne
//    private Role role = Role.ROLE_Admin;
//    @OneToOne
//    private Contact contact;

}
