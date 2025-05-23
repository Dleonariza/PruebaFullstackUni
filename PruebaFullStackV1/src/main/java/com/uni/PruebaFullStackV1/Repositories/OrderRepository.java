package com.uni.PruebaFullStackV1.Repositories;

import com.uni.PruebaFullStackV1.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT MAX(o.numOrder) FROM Order o")
    public Optional<String> findMaxNumOrder();

    public Order findOrderByNumOrder (String numOrder);
}
