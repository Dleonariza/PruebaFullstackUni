package com.uni.PruebaFullStackV1.Repositories;

import com.uni.PruebaFullStackV1.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
