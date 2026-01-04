package com.ecart.order_service.controller;


import com.ecart.order_service.dto.OrderDto;
import com.ecart.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
//@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<Object> saveOrderDtls(@RequestBody OrderDto orderDto){

        OrderDto orderDto1 = orderService.saveOrderDtls(orderDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto1);
    }



    @GetMapping("/get")
    public ResponseEntity<Object> getOrderDtls(@RequestParam int id){

        OrderDto orderDto = orderService.getOrderDtls(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(orderDto);

    }



}
