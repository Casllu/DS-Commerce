package com.lucasalmeida.dscommerce.repositories;

import com.lucasalmeida.dscommerce.entities.Order;
import com.lucasalmeida.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
