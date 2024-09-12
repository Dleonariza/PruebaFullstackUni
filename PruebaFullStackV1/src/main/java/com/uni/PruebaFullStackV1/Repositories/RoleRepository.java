package com.uni.PruebaFullStackV1.Repositories;

import com.uni.PruebaFullStackV1.Models.RolesAndPermissions.RoleEntity;
import com.uni.PruebaFullStackV1.Models.RolesAndPermissions.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    List<RoleEntity> findRoleEntitiesByRoleIn(List<RoleEnum> role);
}
