package kg.megalab.productservice.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ProductDto {

    Long productId;
    String name;
    String description;
    BigDecimal price;
    int quantity;
    boolean available;

}
