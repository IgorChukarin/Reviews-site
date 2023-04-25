package com.example.Eshop.controller;

import com.example.Eshop.domain.Product;
import com.example.Eshop.repos.ProductRepo;
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
    @Autowired
    private ProductRepo productRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Product> products = productRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            products = productRepo.findByTag(filter);
        } else {
            products = productRepo.findAll();
        }

        model.addAttribute("products", products);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name,
                      @RequestParam Integer cost,
                      @RequestParam String tag,
                      @RequestParam("file") MultipartFile file,
                      Map<String, Object> model) throws IOException {
        Product product = new Product(name, cost, tag);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));
            product.setFilename(resultFileName);
        }

        productRepo.save(product);
        Iterable<Product> products = productRepo.findAll();
        model.put("products", products);
        return "main";
    }

    @PostMapping("delete")
    public String delete(@RequestParam Integer id, Model model) {
        productRepo.deleteById(id);
        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products", products);
        return "main";
    }

    @PostMapping("update")
    public String update(@RequestParam Integer id,
                         @RequestParam(required = false, defaultValue = "") String name,
                         @RequestParam(required = false, defaultValue = "0") Integer cost,
                         @RequestParam(required = false, defaultValue = "") String tag,
                         Model model) {
        Product productBeingChanged = productRepo.findById(id).get();
        if (!name.equals("")) {
            productBeingChanged.setName(name);
        }
        if (!(cost == 0)){
            productBeingChanged.setCost(cost);
        }
        if (!tag.equals("")){
            productBeingChanged.setTag(tag);
        }
        productRepo.save(productBeingChanged);
        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products", products);
        return "main";
    }
}
