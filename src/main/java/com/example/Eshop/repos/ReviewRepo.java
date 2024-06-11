package com.example.Eshop.repos;

import com.example.Eshop.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
