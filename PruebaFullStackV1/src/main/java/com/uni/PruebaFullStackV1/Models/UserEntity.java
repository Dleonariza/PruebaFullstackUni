package com.uni.PruebaFullStackV1.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "id_user")
    @NotBlank(message = "ID user must not go empty")
    @Size(max = 10)
    private String idUser;

    @Column(nullable = false)
    @NotBlank(message = "Name must not go empty")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Last name must not go empty")
    private String lastName;

    @Column(unique = true, length = 11, nullable = false)
    @NotBlank(message = "Number phone must not go empty")
    @Size(max = 11)
    private String numberPhone;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email must not go empty")
    @Email(message = "Mail is not formatted correctly.")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Password must not go empty")
    private String password;

    @Column(nullable = false)
    @NotBlank
    private String address;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();
}
