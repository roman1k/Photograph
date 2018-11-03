package progectx.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRating;
    private  int countOfLikes;
    private int mark;
    private int averageOfRating;

    public Rating(int countOfLikes, int mark, int averageOfRating) {
        this.countOfLikes = countOfLikes;
        this.mark = mark;
        this.averageOfRating = averageOfRating;
    }
}
