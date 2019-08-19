package com.shiro.products.service;

import com.shiro.products.model.entity.Product;

import java.util.List;

public interface ImplProductService {
    public List<Product> findAll();
    public Product findById(Long id);
}
