package mk.ukim.finki.labapp.web.controller;

import mk.ukim.finki.labapp.model.Review;
import mk.ukim.finki.labapp.model.Song;
import mk.ukim.finki.labapp.service.ReviewService;
import mk.ukim.finki.labapp.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/song-details")
public class SongDetailsController {

    private final SongService songService;
    private final ReviewService reviewService;

    public SongDetailsController(SongService songService, ReviewService reviewService) {
        this.songService = songService;
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public String getSongDetailsPage(@PathVariable Long id,
                                     Model model) {

        Song song = songService.findBySongId(id);
        List<Review> reviews = reviewService.getReviewsBySongId(id);
        model.addAttribute("songId", id);
        model.addAttribute("reviews", reviews);
        model.addAttribute("trackId", song.getTrackId());
        model.addAttribute("songTitle", song.getTitle());
        model.addAttribute("genre", song.getGenre());
        model.addAttribute("year", song.getReleaseYear());
        model.addAttribute("album", song.getAlbum().getName());
        model.addAttribute("artists", song.getArtists());
        return "songDetails";
    }


}
