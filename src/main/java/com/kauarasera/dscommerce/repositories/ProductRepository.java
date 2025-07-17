package com.kauarasera.dscommerce.repositories;

import com.kauarasera.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//Componente que acessa a entidade Product. Deve informar o tipo da ID do product ao criar o componente
public interface ProductRepository extends JpaRepository<Product, Long> {
}
