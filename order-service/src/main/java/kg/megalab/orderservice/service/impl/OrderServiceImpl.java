package kg.megalab.orderservice.service.impl;

import kg.megalab.orderservice.dto.OrderCreateDto;
import kg.megalab.orderservice.dto.OrderDto;
import kg.megalab.orderservice.dto.ProductsCheckResponseDto;
import kg.megalab.orderservice.feigns.ProductFeign;
import kg.megalab.orderservice.mapper.OrderMapper;
import kg.megalab.orderservice.model.Order;
import kg.megalab.orderservice.model.enums.OrderStatus;
import kg.megalab.orderservice.repository.OrderRepo;
import kg.megalab.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final OrderMapper orderMapper;
    private final ProductFeign productFeign;

    @Override
    public OrderDto createOrder(OrderCreateDto orderCreateDto) {
        List<ProductsCheckResponseDto> productsCheckResponseDtoList = productFeign.checkProducts(orderCreateDto.getProducts());

        if (productsCheckResponseDtoList.stream().anyMatch(x -> !x.isAvailable())){
            throw new RuntimeException("Продукты недоступны!");
        }

        Order order = new Order();
        order.setStatus(OrderStatus.NEW);
        order.setTotalPrice(productsCheckResponseDtoList.stream().map(ProductsCheckResponseDto::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add));

        order = orderRepo.save(order);

        return OrderDto
                .builder()
                .id(order.getId())
                .createdAt(order.getCreatedAt())
                .status(order.getStatus())
                .totalPrice(order.getTotalPrice())
                .build();
    }
}
