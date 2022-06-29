package com.springboot.handling.controller;


import com.springboot.handling.ExceptionHandle.FIleParseException;
import com.springboot.handling.ExceptionHandle.OrderServiceException;
import com.springboot.handling.model.OrderError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

@ControllerAdvice
public class ExceptionAdive {

    private static final SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @ExceptionHandler(OrderServiceException.class)
    public ResponseEntity<OrderError> mepex(OrderServiceException ex){
        OrderError error = new OrderError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage(),sd.format(timestamp) );
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(FIleParseException.class)
    public ResponseEntity<OrderError> mepex1(FIleParseException ex){
        OrderError error = new OrderError(HttpStatus.SERVICE_UNAVAILABLE.value(),ex.getMessage(),sd.format(timestamp));
        return new ResponseEntity<>(error,HttpStatus.SERVICE_UNAVAILABLE);

    }

}
