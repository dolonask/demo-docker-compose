package kg.megalab.orderservice.feigns;

import kg.megalab.orderservice.dto.ProductsCheckRequestDto;
import kg.megalab.orderservice.dto.ProductsCheckResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(url = "http://product-service:8081/")
public interface ProductFeign {
    @PostMapping("/api/products/check")
    List<ProductsCheckResponseDto> checkProducts(@RequestBody List<ProductsCheckRequestDto> productsCheckRequestDtos);
}
