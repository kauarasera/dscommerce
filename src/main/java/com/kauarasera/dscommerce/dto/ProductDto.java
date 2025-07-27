package com.kauarasera.dscommerce.dto;

import com.kauarasera.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDto {

    private Long id;
    @Size(min = 3, max = 80, message = "Name must be 3 to 80 characters long.")
    @NotBlank(message = "Required field.")
    private String name;
    @Size(min = 10, message = "Description must be at least 10 characters long.")
    @NotBlank(message = "Required field.")
    private String description;
    @Positive(message = "The price must be positive.")
    private Double price;
    private String imgUrl;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDto(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
