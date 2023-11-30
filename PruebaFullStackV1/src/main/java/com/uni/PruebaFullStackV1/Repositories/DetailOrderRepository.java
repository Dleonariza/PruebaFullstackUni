package com.uni.PruebaFullStackV1.Repositories;

import com.uni.PruebaFullStackV1.Models.DetailOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailOrderRepository extends JpaRepository<DetailOrder, Long> {
}
