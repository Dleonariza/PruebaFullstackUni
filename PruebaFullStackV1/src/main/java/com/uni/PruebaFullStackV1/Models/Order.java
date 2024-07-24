package com.uni.PruebaFullStackV1.Models;

import com.uni.PruebaFullStackV1.Repositories.OrderRepository;
import com.uni.PruebaFullStackV1.Services.OrderService;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_order", unique = true, nullable = false)
    @Size(max = 8)
    private String numOrder;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<DetailOrder> detailsOrders;


}
