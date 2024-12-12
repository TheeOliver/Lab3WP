package mk.ukim.finki.labapp.service.impl;

import mk.ukim.finki.labapp.model.Review;
import mk.ukim.finki.labapp.model.Song;
import mk.ukim.finki.labapp.repository.jpa.ReviewRepository;
import mk.ukim.finki.labapp.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getReviewsBySongId(Long id) {
        return reviewRepository.findAllBySong_Id(id);
    }

    @Override
    public void addReview(String comment, int rating, Song song) {
        reviewRepository.save(new Review(comment, rating, song));
    }
}
