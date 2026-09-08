package kg.megalab.orderservice.controller;

import kg.megalab.orderservice.dto.OrderCreateDto;
import kg.megalab.orderservice.dto.OrderDto;
import kg.megalab.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderCreateDto orderCreateDto){

        try {
            OrderDto orderDto = orderService.createOrder(orderCreateDto);
            return ResponseEntity.created(null).body(orderDto);
        }catch (RuntimeException r){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

}
