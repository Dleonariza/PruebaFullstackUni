package com.uni.PruebaFullStackV1.Controllers;

import com.uni.PruebaFullStackV1.Controllers.DTO.AuthCreateUser;
import com.uni.PruebaFullStackV1.Models.Order;
import com.uni.PruebaFullStackV1.Models.UserEntity;
import com.uni.PruebaFullStackV1.Services.UserDetailServiceImpl;
import com.uni.PruebaFullStackV1.Services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
@PreAuthorize("permitAll()")
public class UserEntityController {
    private final UserService userService;

    private final UserDetailServiceImpl userDetailService;

   /* @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserEntity user){
        try {
            return ResponseEntity.ok(userService.createUser(user));
        } catch (Exception e)  {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody AuthCreateUser user){
        try {
            return new ResponseEntity<>(userDetailService.createUser(user), HttpStatus.CREATED);
        } catch (Exception e)  {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    @GetMapping("/ordersOfUser")
    public List<Order> ordersOfUser(@RequestParam(name = "id") Long id){
        return  userService.ordersOfUser(id);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam("id") Long id){
        return ResponseEntity.ok(userService.deleteUserById(id));
    }
}
