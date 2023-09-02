package com.example.demo.converter;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import org.springframework.core.convert.converter.Converter;

public class ProductDTOtoProductConverter implements Converter<ProductDTO, Product> {
    @Override
    public Product convert(ProductDTO source) {
        var product = new Product();
        product.setName(source.productName());
        product.setDescription(source.productDescription());
        product.setPrice(source.productPrice());
        product.setCategory(source.productCategory());
        product.setImage(source.productImage());
        return product;
    }
}