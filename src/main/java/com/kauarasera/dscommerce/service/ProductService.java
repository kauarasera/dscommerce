package com.kauarasera.dscommerce.service;

import com.kauarasera.dscommerce.dto.ProductDto;
import com.kauarasera.dscommerce.entities.Product;
import com.kauarasera.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    @Transactional(readOnly = true)
    public ProductDto findyById(Long id) {
        Optional<Product> result = repository.findById(id); //findById por padrao retorna um objeto Optional, estou buscando no banco de dados o produto com a id
        Product product = result.get(); //pegando produto dentro do Optional
        ProductDto dto = new ProductDto(product);//convertendo os objeto para ProductDto
        return dto;
    }
}