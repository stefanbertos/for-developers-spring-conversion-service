package com.example.demo.service;


import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final ConversionService conversionService;

    public Flux<ProductDTO> getAllProducts() {
        return Flux.fromStream(productRepository.findAll().stream().map(product -> conversionService.convert(product, ProductDTO.class)));
    }

    public Mono<ProductDTO> getProductById(Long id) {
        var product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return Mono.just(Objects.requireNonNull(conversionService.convert(product.get(), ProductDTO.class)));
    }

    public Long createProduct(ProductDTO productDTO) {
        var product = conversionService.convert(productDTO, Product.class);
        assert product != null;
        return productRepository.save(product).getId();
    }
}
