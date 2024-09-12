package com.uni.PruebaFullStackV1.Controllers.DTO;

import com.uni.PruebaFullStackV1.Models.RolesAndPermissions.RoleEnum;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public record AuthCreateRoleRequest(@Size(max = 3, message = "The user cannot have more than 3 roles")List<RoleEnum> roleListName) {
}
