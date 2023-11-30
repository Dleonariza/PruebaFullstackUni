package com.uni.PruebaFullStackV1.Repositories;

import com.uni.PruebaFullStackV1.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
