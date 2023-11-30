package com.uni.PruebaFullStackV1.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "details_orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Quantity must not go empty")
    private Integer quantity;

    @ManyToMany
    @JoinTable(
            name = "details_orders_products",
            joinColumns = @JoinColumn(name = "detail_order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
