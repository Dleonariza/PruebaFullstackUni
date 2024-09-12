package com.uni.PruebaFullStackV1.Controllers.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

@Validated
public record AuthCreateUser(@Size(max = 10) String idUser,
                             @Email String email,
                             @NotBlank String name,
                             @NotBlank String lastName,
                             @NotBlank String numberPhone,
                             @NotBlank String address,
                             @NotBlank String username,
                             @NotBlank String password,
                             @Valid AuthCreateRoleRequest roleRequest) {
}
