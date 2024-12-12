package mk.ukim.finki.labapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private int rating;

    @ManyToOne
    private Song song;

    public Review(String comment, int rating, Song song) {
        this.comment = comment;
        this.rating = rating;
        this.song = song;
    }

    public Review(String comment, int rating) {
        this.comment = comment;
        this.rating = rating;
    }
}
