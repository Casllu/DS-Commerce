package com.lucasalmeida.dscommerce.repositories;

import com.lucasalmeida.dscommerce.entities.OrderItem;
import com.lucasalmeida.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,
		OrderItemPK> {

}
