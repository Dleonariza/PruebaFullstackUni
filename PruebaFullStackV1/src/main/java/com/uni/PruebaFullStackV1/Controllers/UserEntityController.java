package com.uni.PruebaFullStackV1.Controllers;

import com.uni.PruebaFullStackV1.Models.UserEntity;
import com.uni.PruebaFullStackV1.Services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserEntityController {
    private final UserService userService;

    @PostMapping("/create")
    public UserEntity createUser(@Valid @RequestBody UserEntity user){
        return userService.createUser(user);
    }

    @PutMapping("/update")
    public UserEntity updateUser(@RequestParam("id") long id, @Valid @RequestBody UserEntity user){
        return userService.updateUser(id, user);
    }

    @GetMapping("/finById")
    public UserEntity findUserById(@RequestParam("id") Long id){
        return userService.findUserById(id);
    }

    @GetMapping("/allUsers")
    public List<UserEntity> allUsers(){
        return userService.allUsers();
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam("id") Long id){
        return ResponseEntity.ok(userService.deleteUserById(id));
    }
}
