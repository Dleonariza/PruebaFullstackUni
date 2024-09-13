package com.uni.PruebaFullStackV1.Controllers.DTO.Order;

import com.uni.PruebaFullStackV1.Models.DetailOrder;

import java.util.List;

public record OrderDTO(String numOrder,
                       List<DetailOrder> detailOrders) {
}
