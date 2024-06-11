package com.example.Eshop.controller;

import com.example.Eshop.domain.Review;
import com.example.Eshop.repos.ReviewRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewRepo repository;

    public ReviewController(ReviewRepo reviewRepo) {
        this.repository = reviewRepo;
    }

    @GetMapping
    public String getReviewPage(Model model) {
        List<Review> reviews = repository.findAll();
        model.addAttribute("reviews", reviews);
        return "reviews";
    }
}
