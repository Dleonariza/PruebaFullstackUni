package com.uni.PruebaFullStackV1.Services;

import com.uni.PruebaFullStackV1.Models.*;
import com.uni.PruebaFullStackV1.Repositories.OrderRepository;
import com.uni.PruebaFullStackV1.Repositories.UserRepository;
import com.uni.PruebaFullStackV1.Services.InterfacesImplements.IUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService implements IUser {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        userEntity.setCreatedAt(LocalDateTime.now());
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity userEntity) {
        UserEntity actuallyUserEntity = findUserById(id);
        String idUser = userEntity.getIdUser();
        actuallyUserEntity.setIdUser(idUser);
        String name = userEntity.getName();
        actuallyUserEntity.setName(name);
        String lastName = userEntity.getLastName();
        actuallyUserEntity.setLastName(lastName);
        String numberPhone = userEntity.getNumberPhone();
        actuallyUserEntity.setNumberPhone(numberPhone);
        String email = userEntity.getEmail();
        actuallyUserEntity.setEmail(email);
        String address = userEntity.getAddress();
        actuallyUserEntity.setAddress(address);
        actuallyUserEntity.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(actuallyUserEntity);
    }

    @Override
    public UserEntity findUserById(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public List<UserEntity> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "Deleted user: " + findUserById(id).getName();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> ordersOfUser(Long id) {
        UserEntity actuallyUserEntity = findUserById(id);

        List<UserOrder> temporary = actuallyUserEntity.getUserOrders();
        List<Order> orders = new ArrayList<>();

        if (!temporary.isEmpty()) {
            for (UserOrder order : temporary) {
                Order orderTemp = orderRepository.getReferenceById(order.getId());
                orders.add(orderTemp);
            }
        }
        return orders;
    }
}
