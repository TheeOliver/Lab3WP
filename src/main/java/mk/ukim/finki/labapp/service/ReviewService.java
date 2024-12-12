package mk.ukim.finki.labapp.service;

import mk.ukim.finki.labapp.model.Review;
import mk.ukim.finki.labapp.model.Song;

import java.util.List;

public interface ReviewService {
    List<Review> getReviewsBySongId(Long id);
    void addReview(String comment, int rating, Song song);
}
