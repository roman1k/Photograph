package progectx.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Admin  extends  User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int Id;



}
