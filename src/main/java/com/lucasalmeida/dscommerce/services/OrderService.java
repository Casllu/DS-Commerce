package com.lucasalmeida.dscommerce.services;

import com.lucasalmeida.dscommerce.dto.OrderDTO;
import com.lucasalmeida.dscommerce.dto.ProductDTO;
import com.lucasalmeida.dscommerce.entities.Order;
import com.lucasalmeida.dscommerce.entities.Product;
import com.lucasalmeida.dscommerce.repositories.OrderRepository;
import com.lucasalmeida.dscommerce.repositories.ProductRepository;
import com.lucasalmeida.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {

        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }
}
