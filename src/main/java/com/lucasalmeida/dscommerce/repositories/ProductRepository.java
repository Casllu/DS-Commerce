package com.lucasalmeida.dscommerce.repositories;

import com.lucasalmeida.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
