package com.kauarasera.dscommerce.service;

import com.kauarasera.dscommerce.dto.ProductDto;
import com.kauarasera.dscommerce.entities.Product;
import com.kauarasera.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional(readOnly = true)
    public Page<ProductDto> findyAll(Pageable pageable) {
        Page<Product> result = repository.findAll(pageable); //findAll por padrao retorna um List, estou buscando no banco de dados todos os produtos com paginacao da lista
        Page<ProductDto> productDtoList = result.map(x -> new ProductDto(x)); //usando lambda para converter Page dos produtos para ProductDto
        return productDtoList;
    }

    @Transactional
    public ProductDto insert(ProductDto dto) {
        Product entity = new Product(); //Intancio, Preparamos o objeto
        copyDtoToEntity(dto, entity); //Copio
        entity = repository.save(entity); //salvo
        return new ProductDto(entity); //Retornamos o objeto salvo atulizado
    }

    @Transactional
    public ProductDto update(Long id, ProductDto dto) {
        Product entity = repository.getReferenceById(id); //instancio um produto da JPA pelo Id do banco de dados COM A REFERENCIA
        copyDtoToEntity(dto, entity); //copia
        entity = repository.save(entity); //salva
        return new ProductDto(entity); //Retornamos o objeto salvo atulizado
    }

    private void copyDtoToEntity(ProductDto dto, Product entity) {
        entity.setName(dto.getName()); //Copiamos os dados do DTO
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
    }
}