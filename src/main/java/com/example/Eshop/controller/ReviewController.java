package com.example.Eshop.controller;

import com.example.Eshop.domain.Review;
import com.example.Eshop.repos.ReviewRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReviewController {

    private final ReviewRepo repository;

    public ReviewController(ReviewRepo reviewRepo) {
        this.repository = reviewRepo;
    }

    @GetMapping("/reviews")
    public String getReviewPage(Model model) {
        List<Review> reviews = repository.findAll();
        model.addAttribute("reviews", reviews);
        return "reviews";
    }

    @GetMapping("/leave-review")
    public String getReviewFormPage() {
        return "review";
    }

    @PostMapping("/leave-review")
    public String saveReview(@RequestParam String header, @RequestParam String text, @RequestParam Integer stars) {
        int id = repository.findAll().size() + 1;
        Review review = new Review();
        review.setId(id);
        review.setHeader(header);
        review.setText(text);
        review.setStars(stars);
        repository.save(review);
        return "redirect:/reviews";
    }
}
