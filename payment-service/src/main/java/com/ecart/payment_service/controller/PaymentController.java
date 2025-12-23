package com.ecart.payment_service.controller;


import com.ecart.payment_service.orderDto.PaymentDto;
import com.ecart.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/save")
    public ResponseEntity<Object> saveOrderDetails(@RequestBody PaymentDto paymentDto){

        PaymentDto paymentSavedDto = paymentService.saveOrderDetails(paymentDto);

        return new ResponseEntity<>(paymentSavedDto, HttpStatus.CREATED);

    }





}
