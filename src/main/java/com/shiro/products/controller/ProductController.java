package com.shiro.products.controller;

import com.shiro.products.model.entity.Product;
import com.shiro.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> allProduct() {
        return this.productService.findAll();
    }

    @GetMapping("/detail")
    public Product productById(@RequestParam(name = "id") Long id) {
        return this.productService.findById(id);
    }




}
