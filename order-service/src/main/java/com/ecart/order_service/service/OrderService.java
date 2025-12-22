package com.ecart.order_service.service;

import com.ecart.order_service.dto.OrderDto;
import com.ecart.order_service.dto.UserDto;
import com.ecart.order_service.entity.Order;
import com.ecart.order_service.exception.OrderNotFoundException;
import com.ecart.order_service.mapper.OrderMapper;
import com.ecart.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    RestTemplate restTemplate;

    public OrderDto saveOrderDtls(OrderDto orderDto) {

        Order order = orderMapper.MapperDtoToEntity(orderDto);

        UserDto userDto = restTemplate.getForObject("http://localhost:8080/user/get/"+order.getUserId(), UserDto.class);

        if(userDto==null){
            throw new RuntimeException("User details not found");
        }
        else {
          Order savedOrder =  orderRepository.save(order);
          return orderMapper.MapperEntityToDto(savedOrder);
        }
    }

    public OrderDto getOrderDtls(int id) {

        Order order = orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order not fount for id"+ id));
        return orderMapper.MapperEntityToDto(order);

    }
}
