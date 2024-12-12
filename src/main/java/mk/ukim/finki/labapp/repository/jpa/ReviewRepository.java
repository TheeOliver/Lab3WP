package mk.ukim.finki.labapp.repository.jpa;

import mk.ukim.finki.labapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllBySong_Id(Long id);
}
