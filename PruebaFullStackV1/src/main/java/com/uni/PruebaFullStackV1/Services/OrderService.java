package com.uni.PruebaFullStackV1.Services;

import com.uni.PruebaFullStackV1.Models.*;
import com.uni.PruebaFullStackV1.Repositories.OrderRepository;
import com.uni.PruebaFullStackV1.Repositories.ProductRepository;
import com.uni.PruebaFullStackV1.Repositories.UserRepository;
import com.uni.PruebaFullStackV1.Services.InterfacesImplements.IOrder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService implements IOrder {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    @Override
    public Order createOrder(Order order) {
        Optional<String> lastNumOrder = orderRepository.findMaxNumOrder();
        if (lastNumOrder.isPresent()){
            String lastOrderNumber = lastNumOrder.get();
            int numericPart = Integer.parseInt(lastOrderNumber.substring(1));
            int nextNumericPart = numericPart + 1;
            order.setNumOrder(String.format("O%07d", nextNumericPart));
        } else {
            order.setNumOrder("O0000001");
        }
        for (DetailOrder detailOrder: order.getDetailsOrders()){
            Long productId = detailOrder.getProduct().getId();
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
            detailOrder.setProduct(product);
        }

        for (UserOrder userOrder : order.getUserOrders()) {
            Long userId =  userOrder.getUser().getId();
            UserEntity user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
            userOrder.setUser(user);
        }
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, List<DetailOrder> detailOrders) {
        Order actuallyOrder = findOrderById(id);
        actuallyOrder.setDetailsOrders(detailOrders);
        return orderRepository.save(actuallyOrder);
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.getReferenceById(id);
    }

    @Override
    public List<Order> allOrders() {
        return orderRepository.findAll();
    }

    @Override
    public String deletedOrder(Long id) {
        orderRepository.deleteById(id);
        return "Deleted order";
    }

    @Override
    public Order findOrderByNumOrder(String numOrder) {
        return orderRepository.findOrderByNumOrder(numOrder);
    }
}
