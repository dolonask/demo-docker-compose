package kg.megalab.productservice.controller;

import kg.megalab.productservice.dto.ProductDto;
import kg.megalab.productservice.dto.ProductsCheckRequestDto;
import kg.megalab.productservice.dto.ProductsCheckResponseDto;
import kg.megalab.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        ProductDto productDto = productService.findById(id);
        return ResponseEntity.ok(productDto);
    }

    @PostMapping("/checks")
    public ResponseEntity<?> productsCheck(@RequestBody List<ProductsCheckRequestDto> productsChecks){
        List<ProductsCheckResponseDto> productsCheckResponseDtos = productService.productsChecks(productsChecks);
        return ResponseEntity.ok(productsCheckResponseDtos);
    }
}
