package com.ecart.payment_service.Mapper;

import com.ecart.payment_service.entity.Payment;
import com.ecart.payment_service.orderDto.PaymentDto;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public Payment MapDdoToEntity(PaymentDto paymentDto){

        Payment payment = new Payment();
        payment.setAmount(paymentDto.getAmount());
        payment.setStatus(paymentDto.getStatus());
        payment.setOrderId(paymentDto.getOrderId());

        return payment;
    }

    public PaymentDto MapEntityToDto(Payment payment){

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setStatus(payment.getStatus());
        paymentDto.setOrderId(payment.getOrderId());

        return paymentDto;
    }



}
