package progectx.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data

public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String namePhoto;
    @ManyToOne
    private  Gallery gallery;

    public Photo(String namePhoto, Gallery gallery) {
        this.namePhoto = namePhoto;
        this.gallery = gallery;
    }

    public Photo(String namePhoto) {
        this.namePhoto = namePhoto;
    }
}
