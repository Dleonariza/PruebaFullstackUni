package com.uni.PruebaFullStackV1.Repositories;

import com.uni.PruebaFullStackV1.Models.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {
}
