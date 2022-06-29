package com.springboot.handling.ExceptionHandle;

public class OrderServiceException extends  Exception{

    public OrderServiceException(String message) {
        super(message);
    }
}
