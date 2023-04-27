package com.example.Eshop.controller;

import com.example.Eshop.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class FavouritesController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/favourites")
    public String greeting() {
        return "favourites";
    }
}
