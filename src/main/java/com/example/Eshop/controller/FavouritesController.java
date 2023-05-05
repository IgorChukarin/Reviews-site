package com.example.Eshop.controller;

import com.example.Eshop.domain.Product;
import com.example.Eshop.domain.User;
import com.example.Eshop.repos.ProductRepo;
import com.example.Eshop.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/*!
	\brief Контроллер избранного, обеспечивает взаимодействие пользоввателя с избранными товарами

	Класс реалезует методы открытия избранных товаров авторзиванным пользователем
*/
@Controller
@RequestMapping("/favourites")
public class FavouritesController {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;

    /// \brief загружает страницу с избранными товарами пользователя
    @GetMapping("{user}")
    public String greeting(@PathVariable User user, Model model) {
        Iterable<Product> products = user.getFavouriteProducts();
        model.addAttribute("products", products);
        return "favourites";
    }
}
