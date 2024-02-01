package com.uni.PruebaFullStackV1.Repositories;

import com.uni.PruebaFullStackV1.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    //@Query(value = "SELECT * FROM users AS u where u.id = :id", nativeQuery = true)
    //public UserEntity userID(@Param("id") Long id);
}
