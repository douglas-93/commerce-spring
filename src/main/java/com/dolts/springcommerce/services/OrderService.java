package com.dolts.springcommerce.services;

import com.dolts.springcommerce.entities.Order;
import com.dolts.springcommerce.entities.User;
import com.dolts.springcommerce.repositories.OrderRepository;
import com.dolts.springcommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = repository.findById(id);
        return order.get();
    }
}
