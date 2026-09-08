package kg.megalab.orderservice.dto;

import kg.megalab.orderservice.model.enums.OrderStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {
    Long id;
    BigDecimal totalPrice;
    OrderStatus status;
    LocalDateTime createdAt;
}
