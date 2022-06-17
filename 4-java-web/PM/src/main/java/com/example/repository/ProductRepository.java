package com.example.repository;

import com.example.entity.Product;

import java.util.List;

public interface ProductRepository {

    void save(Product product);
    List<Product> findAll();
    Product findById(int id);
    void delete(int id);

}
