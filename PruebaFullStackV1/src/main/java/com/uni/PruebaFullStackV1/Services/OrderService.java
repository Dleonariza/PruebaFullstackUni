package com.uni.PruebaFullStackV1.Services;

import com.uni.PruebaFullStackV1.Models.DetailOrder;
import com.uni.PruebaFullStackV1.Models.Order;
import com.uni.PruebaFullStackV1.Repositories.OrderRepository;
import com.uni.PruebaFullStackV1.Services.InterfacesImplements.IOrder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService implements IOrder {

    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
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
}
