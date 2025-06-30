package com.kauarasera.dscommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    ///Para usar o contrutor de forma util nao exponho o OrderItemPK, mas sim as classes Product e o Order no parametro do construtor
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order); ///Estou atribuindo dentro do id de OrderItemPK o order e product
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    ///Os getters e setters precisam ser de Product e Order
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}