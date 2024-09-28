package com.uni.PruebaFullStackV1.Repositories;

import com.uni.PruebaFullStackV1.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public boolean existsProductByCode(String code);

    public List<Product> findProductsByName(String productName);

    public List<Product> findProductByNameContaining(String productName);

    public List<Product> findProductsByType(String productType);

    @Query("SELECT DISTINCT p.type FROM Product p")
    public List<String> allTypes();
}
