package com.example.demo.config;

import com.example.demo.converter.ProductDTOtoProductConverter;
import com.example.demo.converter.ProductToProductDTOConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class ConversionServiceConfig {
    @Bean
    public ConversionService conversionService() {
        var conversionService = new DefaultConversionService();
        conversionService.addConverter(new ProductDTOtoProductConverter());
        conversionService.addConverter(new ProductToProductDTOConverter());
        return conversionService;
    }
}
