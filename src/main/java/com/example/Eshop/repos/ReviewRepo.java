package com.example.Eshop.repos;

import com.example.Eshop.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
    List<Review> findByPinnedTrue();
    List<Review> findByPinnedFalse();
}
