package com.springboot.handling.controller;

import com.springboot.handling.ExceptionHandle.FIleParseException;
import com.springboot.handling.ExceptionHandle.OrderServiceException;
import com.springboot.handling.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/get/{name}")
    public String getOrder(@PathVariable String name) throws FIleParseException {
       int money =   service.getEmployee(name);
       return  "Amount : "+ money;
    }


}
