package com.example.Eshop.controller;

import com.example.Eshop.domain.Review;
import com.example.Eshop.domain.User;
import com.example.Eshop.repos.ReviewRepo;
import com.example.Eshop.repos.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReviewController {

    private final ReviewRepo reviewRepo;
    private final UserRepo userRepo;

    public ReviewController(ReviewRepo reviewRepo, UserRepo userRepo) {
        this.reviewRepo = reviewRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/reviews")
    public String getReviewPage(Model model) {
        List<Review> reviews = reviewRepo.findAll();
        model.addAttribute("reviews", reviews);
        model.addAttribute("reviews", reviews);
        return "reviews";
    }

    @GetMapping("/leave-review")
    public String getReviewFormPage() {
        return "review";
    }

    @PostMapping("/leave-review")
    public String saveReview(@RequestParam String header, @RequestParam String text, @RequestParam Integer stars) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        User user = userRepo.findByUsername(username);

        int id = reviewRepo.findAll().size() + 1;
        Review review = new Review();
        review.setId(id);
        review.setHeader(header);
        review.setText(text);
        review.setStars(stars);
        review.setUser(user);
        reviewRepo.save(review);
        return "redirect:/reviews";
    }
}
