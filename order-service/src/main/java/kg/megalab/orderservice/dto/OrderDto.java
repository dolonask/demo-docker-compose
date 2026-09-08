package kg.megalab.orderservice.dto;

import kg.megalab.orderservice.model.enums.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class OrderDto {
    Long id;
    BigDecimal totalPrice;
    OrderStatus status;
    LocalDateTime createdAt;
}
