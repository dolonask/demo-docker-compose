package kg.megalab.orderservice.service;

import kg.megalab.orderservice.dto.OrderCreateDto;
import kg.megalab.orderservice.dto.OrderDto;

public interface OrderService {

    OrderDto createOrder(OrderCreateDto orderCreateDto);
}
