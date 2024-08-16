package com.uni.PruebaFullStackV1.Services.InterfacesImplements;

import com.uni.PruebaFullStackV1.Models.Order;
import com.uni.PruebaFullStackV1.Models.UserEntity;

import java.util.List;

public interface IUser {
    public UserEntity createUser(UserEntity userEntity);
    public UserEntity updateUser(Long id, UserEntity userEntity);
    public UserEntity findUserById(Long id);
    public List<UserEntity> allUsers();
    public String deleteUserById(Long id);
    public List<Order> ordersOfUser(Long id);
}
