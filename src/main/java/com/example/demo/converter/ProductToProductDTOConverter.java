package com.example.demo.converter;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import org.springframework.core.convert.converter.Converter;

public class ProductToProductDTOConverter implements Converter<Product, ProductDTO> {
    @Override
    public ProductDTO convert(Product source) {
        return new ProductDTO(source.getId(), source.getName(), source.getDescription(), source.getPrice(), source.getCategory(), source.getImage());
    }
}