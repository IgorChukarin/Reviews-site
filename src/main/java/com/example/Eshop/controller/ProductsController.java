package com.example.Eshop.controller;

import com.example.Eshop.domain.Product;
import com.example.Eshop.domain.Role;
import com.example.Eshop.domain.User;
import com.example.Eshop.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping
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

    @GetMapping("{product}")
    public String productForm(@PathVariable Product product, Model model) {
        model.addAttribute("model", model);
        return "product";
    }

    @PostMapping("addToFavourites")
    public String addToFavourites(@RequestParam Product product, Model model) {
        System.out.println(product.getId());
        model.addAttribute("product", product);
        model.addAttribute("model", model);
        return "product";
    }

}
