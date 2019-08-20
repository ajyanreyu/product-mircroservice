package com.shiro.products.service;

import com.shiro.products.model.entity.Product;
import com.shiro.products.model.repository.ProductRepository;
import com.shiro.products.service.impl.ImplProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService implements ImplProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) this.productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }
}
