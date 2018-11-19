package progectx.demo.models;


import  javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "photograph")
public class Photograph   extends UserLog {
    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "id", unique = true, nullable = false, updatable = false)
    private UserLog userLog;
    private Role role = Role.ROLE_USER;
    @OneToMany
    private List<Gallery> galleries = new ArrayList<>();
    @OneToOne
    private  Rating rating;
    private Sex sex;
    private String description;
    private  String avatar;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public void setRole(Role role) {
        this.role = role;
    }

    public List<Gallery> getGalleries() {
        return galleries;
    }

    public void setGalleries(List<Gallery> galleries) {
        this.galleries = galleries;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Photograph() {
    }

    public Photograph(String username, String password) {
        super(username, password);
    }

    public Photograph(String username, String password,Contact contact, String firstName, String lastName ) {
        super(username, password, firstName, lastName, contact);
    }

    @Override
    public String toString() {
        return "Photograph{" +
                getFirstName() +
                getRole() +
                  '}';
    }
}



