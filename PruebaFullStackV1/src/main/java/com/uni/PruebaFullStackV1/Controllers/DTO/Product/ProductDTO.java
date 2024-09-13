package com.uni.PruebaFullStackV1.Controllers.DTO.Product;

import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

public record ProductDTO(String code,
                         String name,
                         BigDecimal price,
                         String type) {
}
