package com.kauarasera.dscommerce.controllers;

import com.kauarasera.dscommerce.dto.ProductDto;
import com.kauarasera.dscommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return service.findyById(id);
    }
}
