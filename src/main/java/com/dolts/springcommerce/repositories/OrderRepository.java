package com.dolts.springcommerce.repositories;

import com.dolts.springcommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
