package com.uni.PruebaFullStackV1.Services.InterfacesImplements;

import com.uni.PruebaFullStackV1.Models.DetailOrder;
import com.uni.PruebaFullStackV1.Models.Order;

import java.util.List;

public interface IOrder {
    public Order createOrder(Order order);
    public Order updateOrder(Long id, List<DetailOrder> detailOrders);
    public Order findOrderById(Long id);
    public List<Order> allOrders();
    public String deletedOrder(Long id);
}
