package mk.ukim.finki.labapp.web.controller;

import mk.ukim.finki.labapp.model.Review;
import mk.ukim.finki.labapp.service.ReviewService;
import mk.ukim.finki.labapp.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;
    private final SongService songService;

    public ReviewController(ReviewService reviewService, SongService songService) {
        this.songService = songService;
        this.reviewService = reviewService;
    }

    @PostMapping("/add/{id}")
    public String addReview(@PathVariable Long id,
                            @RequestParam String comment,
                            @RequestParam String rating) {

        reviewService.addReview(comment, Integer.parseInt(rating), songService.findBySongId(id));
        songService.addReviewToSong(new Review(comment, Integer.parseInt(rating)), songService.findBySongId(id));
        return "redirect:/song-details/" + id;
    }
}
