package com.example.Eshop.controller;

import com.example.Eshop.domain.Product;
import com.example.Eshop.domain.Role;
import com.example.Eshop.domain.User;
import com.example.Eshop.repos.ProductRepo;
import com.example.Eshop.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

/*!
	\brief Класс контроллер для страницы с товарами

	Позволяет просматривать все товары и переходить на страницу конкретного товара
*/
@Controller
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;

    /// \brief загружает страницу товаров
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

    /// \brief загружает страницу конкретного товара
    @GetMapping("{product}")
    public String productForm(@PathVariable Product product, Model model) {
        model.addAttribute("model", model);
        return "product";
    }

    /// \brief добавляет товар в избранное
    @PostMapping("addToFavourites")
    public String addToFavourites(@RequestParam Product product, @RequestParam(required = false) User user, Model model) {
        if (user == null) {
            return "redirect:/login";
        }
        System.out.println(user.getUsername() + " - " + product.getId());
        Set<Product> favouriteProducts = user.getFavouriteProducts();
        favouriteProducts.add(product);
        user.setFavouriteProducts(favouriteProducts);
        userRepo.save(user);
        model.addAttribute("product", product);
        model.addAttribute("model", model);
        return "redirect:/products/" + product.getId();
    }

    /// \brief добавляет товар в корзину
    @PostMapping("addToCart")
    public String addToCart(@RequestParam Product product, @RequestParam(required = false) User user, Model model) {
        if (user == null) {
            return "redirect:/login";
        }
        Set<Product> cartProducts = user.getCartProducts();
        cartProducts.add(product);
        user.setCartProducts(cartProducts);
        userRepo.save(user);
        model.addAttribute("product", product);
        model.addAttribute("model", model);
        System.out.println(product.getId() - user.getId());
        return "redirect:/products/" + product.getId();
    }
}
