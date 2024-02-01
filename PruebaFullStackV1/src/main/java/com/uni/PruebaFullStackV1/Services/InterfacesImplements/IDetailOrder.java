package com.uni.PruebaFullStackV1.Services.InterfacesImplements;

import com.uni.PruebaFullStackV1.Models.DetailOrder;

import java.util.List;

public interface IDetailOrder {
    public DetailOrder createDetailOrder(DetailOrder detailOrder);
    public DetailOrder updateDetailOrder(Long id, DetailOrder detailOrder);
    public DetailOrder findDetailOrderById(Long id);
    public List<DetailOrder> allDetailsOrders();
    public String deleteDetailOrder(Long id);
}
