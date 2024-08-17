package com.uni.PruebaFullStackV1.Models;

import com.uni.PruebaFullStackV1.Repositories.ProductRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 8)
    @Size(max = 8)
    @NotBlank
    private String code;

    public Product () {generateUniqueCode();}
    @PrePersist
    private void generateUniqueCode() {
        if (this.code == null || this.code.isEmpty()) {
            this.code = "P" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        }
    }

    @Column(length = 20, nullable = false)
    @NotBlank(message = "Name product must not go empty")
    @Size(max = 20)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @NotBlank(message = "Type must not go empty")
    private String type;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;
}
