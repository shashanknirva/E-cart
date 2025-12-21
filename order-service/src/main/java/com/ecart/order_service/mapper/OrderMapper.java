package com.ecart.order_service.mapper;

import com.ecart.order_service.dto.OrderDto;
import com.ecart.order_service.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order MapperDtoToEntity(OrderDto orderDto){

        Order order = new Order();
        order.setPrice(orderDto.getPrice());
        order.setProductName(orderDto.getProductName());
        order.setUserId(orderDto.getUserId());

        return order;
    }

    public OrderDto MapperEntityToDto(Order order){

        OrderDto orderDto = new OrderDto();
        orderDto.setPrice(order.getPrice());
        orderDto.setProductName(order.getProductName());
        orderDto.setUserId(order.getUserId());

        return orderDto;
    }






}
