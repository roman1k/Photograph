package progectx.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCity;
    private String nameCity;
    @ManyToOne
    private Contact contact;


    public City(String nameCity) {
        this.nameCity = nameCity;
    }
}
