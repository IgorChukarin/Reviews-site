package com.example.Eshop.controller;

import com.example.Eshop.domain.Product;
import com.example.Eshop.domain.User;
import com.example.Eshop.repos.ProductRepo;
import com.example.Eshop.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
            products = productRepo.findByName(filter);
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userRepo.findByUsername(currentUserName);
        if (currentUser != null) {
            if (currentUser.getFavouriteProducts().contains(product)) {
                model.addAttribute("message", "delete from favourites");
            } else {
                model.addAttribute("message", "add to favourites");
            }
        } else {
            model.addAttribute("message", "add to favourites");
        }
        model.addAttribute("model", model);
        return "product";
    }

    @PostMapping("interactWithFavourites")
    public String interactWithFavourites(@RequestParam Product product, @RequestParam(required = false) User user, Model model) {
        if (user == null) {
            return "redirect:/login";
        }
        Set<Product> favouriteProducts = user.getFavouriteProducts();
        if (user.getFavouriteProducts().contains(product)) {
            favouriteProducts.remove(product);
        } else {
            favouriteProducts.add(product);
        }
        user.setFavouriteProducts(favouriteProducts);
        userRepo.save(user);
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

    @PostMapping("deleteFromCart")
    public String deleteFromCart(@RequestParam Product product, @RequestParam(required = false) User user, Model model) {
        if (user == null) {
            return "redirect:/login";
        }
        Set<Product> cartProducts = user.getCartProducts();
        cartProducts.remove(product);
        user.setCartProducts(cartProducts);
        userRepo.save(user);
        model.addAttribute("product", product);
        model.addAttribute("model", model);
        System.out.println(product.getId() - user.getId());
        return "redirect:/products/" + product.getId();
    }
}
