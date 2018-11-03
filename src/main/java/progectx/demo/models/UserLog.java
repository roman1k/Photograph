package progectx.demo.models;

import lombok.Data;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  abstract class UserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String login;
    private  String password;

    public UserLog(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
