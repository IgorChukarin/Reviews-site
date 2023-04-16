package com.example.Eshop.controller;

import com.example.Eshop.domain.Product;
import com.example.Eshop.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Product> products = productRepo.findAll();
        model.put("products", products);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name, @RequestParam Integer cost, @RequestParam String tag, Map<String, Object> model) {
        Product product = new Product(name, cost, tag);
        productRepo.save(product);

        Iterable<Product> products = productRepo.findAll();
        model.put("products", products);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Product> products;
        if (filter != null && !filter.isEmpty()) {
            products = productRepo.findByTag(filter);
        } else {
            products = productRepo.findAll();
        }
        model.put("products", products);
        return "main";
    }
}
