package progectx.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data

public class Gallery {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private  String nameGallery;
        private String hashTag;
        @OneToMany
        private List<Photo> photos;

    public Gallery( String nameGallery, String hashTag, List<Photo> photos) {
        this.nameGallery = nameGallery;
        this.hashTag = hashTag;
        this.photos = photos;
    }

    public Gallery( String nameGallery, String hashTag) {
        this.nameGallery = nameGallery;
        this.hashTag = hashTag;
    }

    public Gallery( String nameGallery, List<Photo> photos) {
        this.nameGallery = nameGallery;
        this.photos = photos;
    }
}
