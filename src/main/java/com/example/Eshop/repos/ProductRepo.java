package com.example.Eshop.repos;

import com.example.Eshop.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Integer> {
    List<Product> findByTag(String tag);
    List<Product> findByName(String name);
}
