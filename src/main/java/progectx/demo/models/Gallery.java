package progectx.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class Gallery {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @ManyToOne
        private Photograph photograph;
        private  String nameGallery;
        private String hashTag;
        @OneToMany
        private List<Photo> photos;

    public Gallery(Photograph photograph, String nameGallery, String hashTag, List<Photo> photos) {
        this.photograph = photograph;
        this.nameGallery = nameGallery;
        this.hashTag = hashTag;
        this.photos = photos;
    }

    public Gallery(Photograph photograph, String nameGallery, String hashTag) {
        this.photograph = photograph;
        this.nameGallery = nameGallery;
        this.hashTag = hashTag;
    }

    public Gallery(Photograph photograph, String nameGallery, List<Photo> photos) {
        this.photograph = photograph;
        this.nameGallery = nameGallery;
        this.photos = photos;
    }
}
