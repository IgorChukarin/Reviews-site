package com.example.Eshop.controller;

import com.example.Eshop.domain.Product;
import com.example.Eshop.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ProductsController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/products")
    public String greeting(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Product> products = productRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            products = productRepo.findByTag(filter);
        } else {
            products = productRepo.findAll();
        }
        model.addAttribute("products", products);
        model.addAttribute("filter", filter);
        return "products";
    }
}
