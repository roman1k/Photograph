package progectx.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    long countOfLikes;
    double mark;

    double averageOfRating =  Math.round(mark/(double) countOfLikes);

}
