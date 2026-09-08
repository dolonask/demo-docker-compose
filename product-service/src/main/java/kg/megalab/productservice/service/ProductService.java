package kg.megalab.productservice.service;

import kg.megalab.productservice.dto.ProductDto;
import kg.megalab.productservice.dto.ProductsCheckRequestDto;
import kg.megalab.productservice.dto.ProductsCheckResponseDto;
import kg.megalab.productservice.model.Product;

import java.util.List;

public interface ProductService {

    ProductDto findById(Long id);
    List<ProductsCheckResponseDto> productsChecks(List<ProductsCheckRequestDto> productsCheckRequestDtos);

}
