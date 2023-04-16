package com.example.Eshop;

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
public class GreetingController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Product> products = productRepo.findAll();
        model.put("products", products);
        return "main";
    }

    @PostMapping
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
