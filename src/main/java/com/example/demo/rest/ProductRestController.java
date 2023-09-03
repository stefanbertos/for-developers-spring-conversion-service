package com.example.demo.rest;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;

    @GetMapping
    public Flux<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDTO> getProductById(@PathVariable Long id) {
        try {
            return productService.getProductById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product Not Found", e);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createProduct(@RequestBody ProductDTO product) {
        return productService.createProduct(product);
    }
}
