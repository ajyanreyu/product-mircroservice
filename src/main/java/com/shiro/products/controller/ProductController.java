package com.shiro.products.controller;

import com.shiro.products.model.entity.Product;
import com.shiro.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> allProduct() {
        return this.productService.findAll().stream().map(
                product -> {
                    product.setPort(port);
                    return product;
                }).collect(Collectors.toList());
    }

    @GetMapping("/details")
    public Product productById(@RequestParam(name = "id") Long id) {
        Product product = productService.findById(id);
        product.setPort(port);
        return product;
    }


}
