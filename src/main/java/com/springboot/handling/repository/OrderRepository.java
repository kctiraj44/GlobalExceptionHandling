package com.springboot.handling.repository;

import com.springboot.handling.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String > {
    Order findByName(String name);
}
