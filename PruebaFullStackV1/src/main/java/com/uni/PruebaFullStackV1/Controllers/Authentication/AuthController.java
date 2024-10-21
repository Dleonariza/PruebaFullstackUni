package com.uni.PruebaFullStackV1.Controllers.Authentication;

import com.uni.PruebaFullStackV1.Controllers.DTO.AuthCreateUser;
import com.uni.PruebaFullStackV1.Controllers.DTO.AuthLoginRequest;
import com.uni.PruebaFullStackV1.Controllers.DTO.AuthResponse;
import com.uni.PruebaFullStackV1.Services.UserDetailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@PreAuthorize("denyAll()")
public class AuthController {

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @PostMapping("/sing-up")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody AuthCreateUser authCreateUser) {
        return new ResponseEntity<>(this.userDetailService.createUser(authCreateUser), HttpStatus.CREATED);
    }

    @PostMapping("/log-in")
    @PreAuthorize("permitAll()")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest loginRequest) {
        return new ResponseEntity<>(this.userDetailService.loginUser(loginRequest), HttpStatus.OK);
    }
}
