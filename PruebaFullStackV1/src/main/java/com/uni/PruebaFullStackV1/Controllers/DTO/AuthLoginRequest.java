package com.uni.PruebaFullStackV1.Controllers.DTO;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(@NotBlank String username, @NotBlank String password) {
}
