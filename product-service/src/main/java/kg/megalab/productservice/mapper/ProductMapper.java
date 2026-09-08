package kg.megalab.productservice.mapper;

import kg.megalab.productservice.dto.ProductDto;
import kg.megalab.productservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "id", target = "productId")
    ProductDto productToProductDto(Product product);

}
