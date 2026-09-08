package kg.megalab.productservice.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductsCheckResponseDto {
    Long productId;
    String name;
    BigDecimal price;
    int requestedQuantity;
    int availableQuantity;
    boolean available;
}
