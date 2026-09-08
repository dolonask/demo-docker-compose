package kg.megalab.productservice.service.impl;

import kg.megalab.productservice.dto.ProductDto;
import kg.megalab.productservice.dto.ProductsCheckRequestDto;
import kg.megalab.productservice.dto.ProductsCheckResponseDto;
import kg.megalab.productservice.exception.ProductNotFound;
import kg.megalab.productservice.mapper.ProductMapper;
import kg.megalab.productservice.model.Product;
import kg.megalab.productservice.repository.ProductRepo;
import kg.megalab.productservice.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final ProductRepo productRepo;
    final ProductMapper productMapper;

    @Override
    public ProductDto findById(Long id) {
        Product product = productRepo.findById(id).orElseThrow(()->new ProductNotFound("Product with ID = " + id + " not found!"));
        return productMapper.productToProductDto(product);
    }

    @Override
    public List<ProductsCheckResponseDto> productsChecks(List<ProductsCheckRequestDto> productsCheckRequestDtos) {
        List<Product> products = productRepo.findAllById(productsCheckRequestDtos.stream().map(ProductsCheckRequestDto::getProductId).toList());
        if (products.size() != productsCheckRequestDtos.size())
            throw new RuntimeException("Products not found!");


        return products.stream()
                .map(x->{
                    ProductsCheckResponseDto productsCheckResponseDto = new ProductsCheckResponseDto();
                    productsCheckResponseDto.setProductId(x.getId());
                    productsCheckResponseDto.setPrice(x.getPrice());
                    productsCheckResponseDto.setName(x.getName());
                    productsCheckResponseDto.setRequestedQuantity(productsCheckRequestDtos.stream().filter(y-> Objects.equals(y.getProductId(), x.getId())).map(ProductsCheckRequestDto::getQuantity).findAny().get());
                    productsCheckResponseDto.setAvailableQuantity(x.getQuantity());
                    productsCheckResponseDto.setAvailable(productsCheckResponseDto.getAvailableQuantity() >= productsCheckResponseDto.getRequestedQuantity());
                    return productsCheckResponseDto;
                })
                .toList();
    }
}
