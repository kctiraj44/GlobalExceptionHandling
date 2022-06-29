package com.springboot.handling.service;

import com.springboot.handling.ExceptionHandle.FIleParseException;
import com.springboot.handling.ExceptionHandle.OrderServiceException;
import com.springboot.handling.model.Order;
import com.springboot.handling.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @PostConstruct
    public void addingOrder(){
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1","ram","person",12));
        orders.add(new Order("2","hari","person",46));
        repository.save(orders);

    }


    public int getEmployee(String name) throws  FIleParseException {

        int amount;
        Order order = null;
        try {
             order =  repository.findByName(name);
             amount = order.getAmount();
        }catch (Exception ex){
            throw new FIleParseException("*--File is not in correct format--*");
        }

       return amount;
    }

}
