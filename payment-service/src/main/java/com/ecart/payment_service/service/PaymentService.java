package com.ecart.payment_service.service;

import com.ecart.payment_service.Mapper.PaymentMapper;
import com.ecart.payment_service.entity.Payment;
import com.ecart.payment_service.orderDto.PaymentDto;
import com.ecart.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    PaymentMapper paymentMapper;

    public PaymentDto saveOrderDetails(PaymentDto paymentDto) {

        Payment payment = paymentMapper.MapDdoToEntity(paymentDto);
        Payment paymentSaved = paymentRepository.save(payment);
        if(paymentSaved!=null) {
            return paymentMapper.MapEntityToDto(paymentSaved);
        }
        else{
            throw new RuntimeException("Save failed");
        }
    }
}
