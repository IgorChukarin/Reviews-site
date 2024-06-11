package com.example.Eshop.controller;

import com.example.Eshop.domain.Product;
import com.example.Eshop.domain.User;
import com.example.Eshop.repos.ProductRepo;
import com.example.Eshop.repos.UserRepo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }
}
