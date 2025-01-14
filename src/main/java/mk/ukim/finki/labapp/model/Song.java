package mk.ukim.finki.labapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;

    @ManyToMany(mappedBy = "songs")
    private List<Artist> artists = new ArrayList<>();

    @ManyToOne
    private Album album;

    @OneToMany(mappedBy = "song")
    private List<Review> reviews = new ArrayList<>();

    public Song(String trackId, String title, String genre, int releaseYear, Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album = album;
    }

    public Song(String trackId, String title, String genre, int releaseYear, List<Artist> artists, Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.artists = artists;
        this.album = album;
    }

}
