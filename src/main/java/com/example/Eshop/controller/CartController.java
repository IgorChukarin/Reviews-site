package com.example.Eshop.controller;

import com.example.Eshop.domain.Product;
import com.example.Eshop.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping
    public String greeting(Model model) {
        ArrayList<Product> products = new ArrayList<>();
        model.addAttribute("products", products);
        return "cart";
    }

    @GetMapping("{user}")
    public String usersCart(@PathVariable User user, Model model) {
        Iterable<Product> products = user.getCartProducts();
        int totalCost = 0;
        for (Product product : products) {
            totalCost += product.getCost();
        }
        model.addAttribute("products", products);
        model.addAttribute("totalCost", totalCost);
        return "cart";
    }
}

