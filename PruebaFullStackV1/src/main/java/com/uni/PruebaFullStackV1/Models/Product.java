package com.uni.PruebaFullStackV1.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 8)
    @Size(max = 8)
    @NotBlank
    //Autogenerado
    private String code;

    @Column(length = 20, nullable = false)
    @NotBlank(message = "Name product must not go empty")
    @Size(max = 20)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @NotBlank(message = "Type must not go empty")
    private String type;
}
