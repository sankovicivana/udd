package com.udd.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.udd.project.indexmodel.Product;

import com.udd.project.service.ProductService;

/**
 * ProductController
 */
@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductService productService;


    @GetMapping("/findAll")
    Iterable<Product> findAll() {
        return productService.getProducts();
    }
}