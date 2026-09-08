package kg.megalab.orderservice.model;

import jakarta.persistence.*;
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
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    Long id;
    BigDecimal totalPrice;
    OrderStatus status;
    LocalDateTime createdAt;

    @PrePersist
    public void setCreatedAt(){
        createdAt = LocalDateTime.now();
    }
}
