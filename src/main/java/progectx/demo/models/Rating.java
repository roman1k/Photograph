package progectx.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRating;
    private int countOfLikes = 0;
    private int mark = 0;
    private int averageOfRating = 0;
    @OneToMany
    private List<UserLog> WhoLiked;

    public Rating(int countOfLikes, int mark, int averageOfRating, List<UserLog> whoLiked) {
        this.countOfLikes = countOfLikes;
        this.mark = mark;
        this.averageOfRating = averageOfRating;
        WhoLiked = whoLiked;
    }

    public Rating(int mark, List<UserLog> whoLiked) {
        this.mark = mark;
        WhoLiked = whoLiked;
    }

    public Rating() {
    }
}




