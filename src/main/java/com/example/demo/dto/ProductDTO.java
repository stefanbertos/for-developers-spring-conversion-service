package com.example.demo.dto;

public record ProductDTO(Long productId, String productName, String productDescription, Float productPrice,
                         String productImage, String productCategory) {
}

